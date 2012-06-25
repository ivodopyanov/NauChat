/*$Id$*/
package ru.naumen.NauChat.server.dispatch;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;
import ru.naumen.NauChat.shared.GetMessageListAction;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class ActionsModule extends ActionHandlerModule
{
    @Override
    protected void configureHandlers()
    {
        bindHandler(GetMessageListAction.class, GetMessageListActionHandler.class);
    }
}