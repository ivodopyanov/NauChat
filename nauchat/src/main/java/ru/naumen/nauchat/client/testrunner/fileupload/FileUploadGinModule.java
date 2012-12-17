/**
 * 
 */
package ru.naumen.nauchat.client.testrunner.fileupload;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class FileUploadGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(FileUploadDisplay.class).to(FileUploadDisplayImpl.class);
        bind(FileUploadPresenter.class);
    }
}