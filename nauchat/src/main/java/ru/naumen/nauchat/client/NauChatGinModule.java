/*$Id$*/
package ru.naumen.nauchat.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;
import ru.naumen.nauchat.client.auth.CheckLoginDisplay;
import ru.naumen.nauchat.client.auth.CheckLoginDisplayImpl;
import ru.naumen.nauchat.client.auth.LoginService;
import ru.naumen.nauchat.client.auth.LoginServiceStub;
import ru.naumen.nauchat.client.resources.NauChatListResources;
import ru.naumen.nauchat.client.resources.NauChatResources;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Модуль Google Gin для реализации механизма Dependency Injection на стороне клиента
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatGinModule extends AbstractGinModule
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
        bind(NauChatResources.class).in(Singleton.class);
        bind(NauChatListResources.class).in(Singleton.class);

        bind(NauChatDisplay.class).to(NauChatDisplayImpl.class);
        bind(CheckLoginDisplay.class).to(CheckLoginDisplayImpl.class);
        bind(EventBus.class).to(DefaultEventBus.class);
        bind(NauChatListDataProvider.class);
        bind(DispatchAsync.class).toProvider(DispatchProvider.class).in(Singleton.class);
        bind(PlaceManager.class).in(Singleton.class);
        bind(LoginService.class).to(LoginServiceStub.class);
        //@formatter:off
        bind(new TypeLiteral<Cell<String>>(){}).annotatedWith(Names.named(NauChatDisplay.NAU_CHAT_CELL_CODE)).to(TextCell.class);
        //@formatter:on
    }
}