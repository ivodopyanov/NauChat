/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatGinModule extends AbstractGinModule
{

    @Override
    protected void configure()
    {
        bind(NauChatDisplay.class).to(NauChatDisplayImpl.class);
        bind(EventBus.class).to(DefaultEventBus.class);
        //@formatter:off
        bind(new TypeLiteral<Cell<String>>(){}).annotatedWith(Names.named(NauChatDisplay.NAU_CHAT_CELL_CODE)).to(TextCell.class);
        //@formatter:on
    }
}