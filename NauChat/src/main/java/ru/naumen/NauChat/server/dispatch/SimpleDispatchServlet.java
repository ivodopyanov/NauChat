/*$Id$*/
package ru.naumen.NauChat.server.dispatch;

import net.customware.gwt.dispatch.client.standard.StandardDispatchService;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.server.InstanceActionHandlerRegistry;
import net.customware.gwt.dispatch.server.SimpleDispatch;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.DispatchException;
import net.customware.gwt.dispatch.shared.Result;
import ru.naumen.NauChat.server.NauChatGuiceModule;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class SimpleDispatchServlet extends RemoteServiceServlet implements StandardDispatchService
{
    private Dispatch dispatch;

    public SimpleDispatchServlet()
    {
        Injector injector = Guice.createInjector(new NauChatGuiceModule());
        InstanceActionHandlerRegistry registry = injector.getInstance(InstanceActionHandlerRegistry.class);
        registry.addHandler(injector.getInstance(GetMessageListActionHandler.class));
        dispatch = new SimpleDispatch(registry);
    }

    public Result execute(Action<?> action) throws DispatchException
    {
        try
        {
            return dispatch.execute(action);
        }
        catch (RuntimeException e)
        {
            log("Exception while executing " + action.getClass().getName() + ": " + e.getMessage(), e);
            throw e;
        }
    }
}