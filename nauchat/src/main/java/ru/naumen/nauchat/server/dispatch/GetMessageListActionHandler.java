/*$Id$*/
package ru.naumen.nauchat.server.dispatch;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;
import ru.naumen.nauchat.server.MessagingService;
import ru.naumen.nauchat.shared.action.GetMessageListAction;
import ru.naumen.nauchat.shared.action.MessageListResult;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Обработчик @GetMessageListAction - обращается к сервису @MessagingService
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class GetMessageListActionHandler implements ActionHandler<GetMessageListAction, MessageListResult>
{
    @Inject
    MessagingService messagingService;

    public MessageListResult execute(GetMessageListAction arg0, ExecutionContext arg1) throws DispatchException
    {
        return new MessageListResult(Lists.newArrayList(messagingService.getMessages()));
    }

    public Class<GetMessageListAction> getActionType()
    {
        return GetMessageListAction.class;
    }

    public void rollback(GetMessageListAction arg0, MessageListResult arg1, ExecutionContext arg2)
            throws DispatchException
    {
    }
}