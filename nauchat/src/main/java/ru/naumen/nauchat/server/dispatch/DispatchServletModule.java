/*$Id$*/
package ru.naumen.nauchat.server.dispatch;

import net.customware.gwt.dispatch.server.guice.GuiceStandardDispatchServlet;

import com.google.inject.servlet.ServletModule;

/**
 * Класс, необходимый для реализации gwt-dispatch на стороне сервера через Google Guice
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class DispatchServletModule extends ServletModule
{
    @Override
    protected void configureServlets()
    {
        serve("/nauchat/dispatch").with(GuiceStandardDispatchServlet.class);
    }
}