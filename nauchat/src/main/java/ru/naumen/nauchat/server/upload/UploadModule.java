/**
 * 
 */
package ru.naumen.nauchat.server.upload;

import javax.inject.Singleton;

import ru.naumen.nauchat.server.hibernate.HibernateModule;

import com.google.inject.AbstractModule;

/**
 * @author ivodopyanov
 * @since 19.12.2012
 * 
 */
public class UploadModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new HibernateModule());
        bind(UploadService.class).to(UploadServiceImpl.class).in(Singleton.class);
    }
}