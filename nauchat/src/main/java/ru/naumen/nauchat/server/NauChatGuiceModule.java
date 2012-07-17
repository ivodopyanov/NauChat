/*$Id$*/
package ru.naumen.nauchat.server;

import net.customware.gwt.dispatch.server.DefaultActionHandlerRegistry;
import net.customware.gwt.dispatch.server.InstanceActionHandlerRegistry;
import ru.naumen.nauchat.server.dispatch.GetMessageListActionHandler;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Модуль Google Guice - для реализации механизма Dependency Injection на стороне сервера.
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class NauChatGuiceModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(MessagingService.class).to(MessagingServiceImpl.class).in(Singleton.class);
        bind(InstanceActionHandlerRegistry.class).to(DefaultActionHandlerRegistry.class);
        bind(GetMessageListActionHandler.class);
    }
}