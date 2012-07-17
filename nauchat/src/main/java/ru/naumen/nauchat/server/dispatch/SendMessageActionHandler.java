package ru.naumen.nauchat.server.dispatch;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;
import ru.naumen.nauchat.server.MessagingService;
import ru.naumen.nauchat.shared.action.MessageListResult;
import ru.naumen.nauchat.shared.action.SendMessageAction;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class SendMessageActionHandler implements ActionHandler<SendMessageAction, MessageListResult>
{
    @Inject
    MessagingService messagingService;

    @Override
    public MessageListResult execute(SendMessageAction action, ExecutionContext context) throws DispatchException
    {
        return new MessageListResult(Lists.newArrayList(messagingService.addMessage(action.getNewMessage())));
    }

    @Override
    public Class<SendMessageAction> getActionType()
    {
        return SendMessageAction.class;
    }

    @Override
    public void rollback(SendMessageAction arg0, MessageListResult arg1, ExecutionContext arg2)
            throws DispatchException
    {

    }
}
