/*$Id$*/
package ru.naumen.NauChat.server;

import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;
import ru.naumen.NauChat.server.dispatch.ActionsModule;
import ru.naumen.NauChat.server.dispatch.DispatchServletModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Класс, необходимый для реализации gwt-dispatch на стороне сервера через Google Guice
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class NauChatGuiceServletConfig extends GuiceServletContextListener
{
    @Override
    protected Injector getInjector()
    {
        return Guice.createInjector(new ServerDispatchModule(), new ActionsModule(), new DispatchServletModule(),
                new NauChatGuiceModule());
    }
}