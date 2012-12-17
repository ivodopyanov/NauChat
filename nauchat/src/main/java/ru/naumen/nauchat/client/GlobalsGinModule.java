/**
 * 
 */
package ru.naumen.nauchat.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class GlobalsGinModule extends AbstractGinModule
{
    static class DispatchProvider implements Provider<DispatchAsync>
    {
        @Override
        public DispatchAsync get()
        {
            return new StandardDispatchAsync(new DefaultExceptionHandler());
        }
    }

    @Override
    protected void configure()
    {
        bind(EventBus.class).to(DefaultEventBus.class);
        bind(DispatchAsync.class).toProvider(GlobalsGinModule.DispatchProvider.class).in(Singleton.class);
        bind(PlaceManager.class).in(Singleton.class);
    }
}