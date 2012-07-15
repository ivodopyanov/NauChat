/*$Id$*/
package ru.naumen.NauChat.server.dispatch;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;
import ru.naumen.NauChat.shared.action.GetMessageListAction;
import ru.naumen.NauChat.shared.action.SendMessageAction;

/**
 * Класс, определяющий отношения между Action и обрабатывающими их ActionHandler
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class ActionsModule extends ActionHandlerModule
{
    @Override
    protected void configureHandlers()
    {
        bindHandler(GetMessageListAction.class, GetMessageListActionHandler.class);
        bindHandler(SendMessageAction.class, SendMessageActionHandler.class);
    }
}