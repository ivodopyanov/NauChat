/* $Id$ */
package ru.naumen.nauchat.server.upload;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Status;
import javax.transaction.Synchronization;
import javax.transaction.TransactionManager;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.naumen.nauchat.server.hibernate.dao.DBFileItemDao;
import ru.naumen.nauchat.shared.UUIDGenerator;

/**
 * Реализация {@link UploadService}.
 * <p>
 * Может работать в двух режимах:
 * <ol>
 * <li>Локальном - т.е. приложение поднято не в кластере. Временные файлы
 * храняться в директории временных файлов на диске</li>
 * <li>Распределенном - т.е. приложение работает в кластере, а файлы храняться в
 * БД. В этом случае загруженные файлы доступны на всех нодах кластера.</li>
 * </ol>
 * У локального способа хранения файлов меньше накладных расходов т.к. нет
 * необходимости записывать файлы в БД.
 * 
 * @author nshestakov
 * 
 */
public class UploadServiceImpl implements UploadService
{
    /**
     * Стратегия хранения файлов в БД
     */
    class ClusterStoreStrategy implements StoreStrategy
    {
        @Override
        public void add(String uuid, FileItem item)
        {
            itemDao.save(uuid, item);
        }

        @Override
        public void delete(String uuid, boolean reuse)
        {
            itemDao.delete(uuid, reuse);
        }

        @Override
        public void destroy()
        {
        }

        @Override
        public FileItem get(String uuid)
        {
            return itemDao.get(uuid);
        }
    }

    /**
     * Стратегия хранения файлов.
     * 
     * @see UploadServiceImpl
     */
    interface StoreStrategy
    {
        void add(String uuid, FileItem item);

        void delete(String uuid, boolean reuse);

        void destroy();

        FileItem get(String uuid);
    }

    class TxSync implements Synchronization
    {
        private final String uuid;

        public TxSync(String uuid)
        {
            this.uuid = uuid;
        }

        @Override
        public void afterCompletion(int status)
        {
            if (Status.STATUS_COMMITTED == status)
            {
                Session session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                delete(uuid);
                tx.commit();
            }
        }

        @Override
        public void beforeCompletion()
        {
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(UploadService.class);

    @Inject
    TransactionManager txManager;
    @Inject
    DBFileItemDao itemDao;
    @Inject
    SessionFactory sessionFactory;

    StoreStrategy strategy;

    @Override
    public String add(FileItem item)
    {
        String uuid = UUIDGenerator.get().nextUUID();
        strategy.add(uuid, item);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Added resource with uuid=" + uuid);
        }
        return uuid;
    }

    @Override
    public void delete(String uuid)
    {
        strategy.delete(uuid, false);
    }

    @Override
    public void deleteOnTx(String uuid)
    {
        try
        {
            txManager.getTransaction().registerSynchronization(new TxSync(uuid));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void destroy()
    {
        strategy.destroy();
    }

    @Override
    public FileItem get(String uuid)
    {
        FileItem fileItem = strategy.get(uuid);
        if (null == fileItem)
        {
            throw new RuntimeException("Resource with uuid=" + uuid + " not found");
        }
        return fileItem;
    }

    @Inject
    public void init()
    {
        LOG.info("Use cluster store strategy");
        strategy = new ClusterStoreStrategy();
    }
}
