/* $Id$ */
package ru.naumen.nauchat.server.hibernate.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.activation.MimetypesFileTypeMap;
import javax.inject.Inject;

import org.apache.commons.fileupload.FileItem;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.SingleTableEntityPersister;

import ru.naumen.nauchat.server.hibernate.entity.DBFileItem;

/**
 * DAO для работы с {@link DBFileItem}
 * 
 * @author nshestakov
 */
public class DBFileItemDao
{
    @Inject
    SessionFactory sessionFactory;

    private final MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();

    public void delete(final String uuid, final boolean reuse)
    {
        final Session session = getSession();
        session.doWork(new Work()
        {
            @Override
            public void execute(Connection connection) throws SQLException
            {
                ClassMetadata clsMD = session.getSessionFactory().getClassMetadata(DBFileItem.class);
                String tableName = ((SingleTableEntityPersister)clsMD).getTableName();
                if (!reuse && "PostgreSQL".equals(connection.getMetaData().getDatabaseProductName()))
                {
                    try (PreparedStatement psmt = connection.prepareStatement("select lo_unlink(file_content) from "
                            + tableName + " where uuid=?"))
                    {
                        psmt.setString(1, uuid);
                        psmt.execute();
                    }
                }
                try (PreparedStatement psmt = connection.prepareStatement("delete from " + tableName + " where uuid=?"))
                {
                    psmt.setString(1, uuid);
                    psmt.execute();
                }
            }
        });
    }

    public FileItem get(String uuid)
    {
        return (FileItem)getSession().get(DBFileItem.class, uuid);
    }

    public void save(String uuid, File file)
    {
        try (FileInputStream fis = new FileInputStream(file))
        {
            long size = fis.getChannel().size();
            DBFileItem dbItem = new DBFileItem();
            dbItem.setContentType(mimeTypesMap.getContentType(file));
            dbItem.setFieldName("");
            dbItem.setFormField(false);
            dbItem.setName(file.getName());
            dbItem.setSize(size);
            dbItem.setUuid(uuid);
            dbItem.setContent(Hibernate.getLobCreator(getSession()).createBlob(fis, size));

            getSession().save(dbItem);
            getSession().flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void save(String uuid, FileItem item)
    {
        try
        {
            DBFileItem dbItem = new DBFileItem();
            dbItem.setContentType(item.getContentType());
            dbItem.setFieldName(item.getFieldName());
            dbItem.setFormField(item.isFormField());
            dbItem.setName(item.getName());
            dbItem.setSize(item.getSize());
            dbItem.setUuid(uuid);
            dbItem.setContent(Hibernate.getLobCreator(getSession()).createBlob(item.getInputStream(), item.getSize()));

            getSession().save(dbItem);
            getSession().flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

}
