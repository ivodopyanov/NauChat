/* $Id$ */
package ru.naumen.nauchat.client;

import ru.naumen.nauchat.client.auth.AuthGinModule;
import ru.naumen.nauchat.client.old.OldGinModule;
import ru.naumen.nauchat.client.resources.ResourcesGinModule;
import ru.naumen.nauchat.client.testrunner.PlayerGinModule;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Модуль Google Gin для реализации механизма Dependency Injection на стороне
 * клиента
 * 
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class MainGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        install(new GlobalsGinModule());
        install(new AuthGinModule());
        install(new PlayerGinModule());
        install(new OldGinModule());
        install(new ResourcesGinModule());
    }
}