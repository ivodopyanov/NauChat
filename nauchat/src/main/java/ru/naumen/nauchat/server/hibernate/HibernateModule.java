/**
 * 
 */
package ru.naumen.nauchat.server.hibernate;

import org.hibernate.SessionFactory;

import ru.naumen.nauchat.server.hibernate.dao.HibernateDaoModule;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * @author ivodopyanov
 * @since 19.12.2012
 * 
 */
public class HibernateModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new HibernateDaoModule());
        bind(SessionFactory.class).toProvider(SessionFactoryProvider.class).in(Singleton.class);
    }
}