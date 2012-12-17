/**
 * 
 */
package ru.naumen.nauchat.server.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ru.naumen.nauchat.server.entity.Player;
import ru.naumen.nauchat.server.entity.SourceCode;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class HibernateUtils
{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
            buildSessionFactory();
        return sessionFactory;
    }

    public static void shutdown()
    {
        sessionFactory.close();
    }

    private static void buildSessionFactory()
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(SourceCode.class);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

}
