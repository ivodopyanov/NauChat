/**
 * 
 */
package ru.naumen.nauchat.client.testrunner;

import ru.naumen.nauchat.client.testrunner.fileupload.FileUploadGinModule;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class PlayerGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        install(new FileUploadGinModule());
        bind(PlayerDisplay.class).to(PlayerDisplayImpl.class);
        bind(PlayerPresenter.class);
        bind(PlayerMessages.class).in(Singleton.class);
    }
}