/**
 * 
 */
package ru.naumen.nauchat.server.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ru.naumen.nauchat.server.hibernate.entity.DBFileItem;
import ru.naumen.nauchat.server.hibernate.entity.Player;
import ru.naumen.nauchat.server.hibernate.entity.SourceCode;

import com.google.inject.Provider;

/**
 * @author ivodopyanov
 * @since 19.12.2012
 * 
 */
public class SessionFactoryProvider implements Provider<SessionFactory>
{

    @Override
    public SessionFactory get()
    {
        Configuration configuration = new Configuration();
        //@formatter:off
        configuration.configure()
            .addAnnotatedClass(Player.class)
            .addAnnotatedClass(SourceCode.class)
            .addAnnotatedClass(DBFileItem.class);
        //@formatter:on

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}