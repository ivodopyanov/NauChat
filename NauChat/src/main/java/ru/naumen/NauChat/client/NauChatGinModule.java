/*$Id$*/
package ru.naumen.NauChat.client;

import ru.naumen.NauChat.client.resources.NauChatListResources;
import ru.naumen.NauChat.client.resources.NauChatResources;
import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

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
        bind(EventBus.class).to(DefaultEventBus.class);
        bind(NauChatListDataProvider.class);
        bind(DispatchAsync.class).toProvider(DispatchProvider.class).in(Singleton.class);

        //@formatter:off
        bind(new TypeLiteral<Cell<String>>(){}).annotatedWith(Names.named(NauChatDisplay.NAU_CHAT_CELL_CODE)).to(TextCell.class);
        //@formatter:on
    }
}