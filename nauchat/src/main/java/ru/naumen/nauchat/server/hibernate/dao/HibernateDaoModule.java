/**
 * 
 */
package ru.naumen.nauchat.server.hibernate.dao;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * @author ivodopyanov
 * @since 19.12.2012
 * 
 */
public class HibernateDaoModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(DBFileItemDao.class).in(Singleton.class);
    }
}