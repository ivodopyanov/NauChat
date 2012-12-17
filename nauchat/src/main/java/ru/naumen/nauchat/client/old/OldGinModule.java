/**
 * 
 */
package ru.naumen.nauchat.client.old;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class OldGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(NauChatDisplay.class).to(NauChatDisplayImpl.class);
        bind(NauChatListDataProvider.class);

        //@formatter:off
        bind(new TypeLiteral<Cell<String>>(){}).annotatedWith(Names.named(NauChatDisplay.NAU_CHAT_CELL_CODE)).to(TextCell.class);
        //@formatter:on
    }
}