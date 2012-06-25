/*$Id$*/
package ru.naumen.NauChat.server.dispatch;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;
import ru.naumen.NauChat.server.MessagingService;
import ru.naumen.NauChat.shared.GetMessageListAction;
import ru.naumen.NauChat.shared.GetMessageListResult;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class GetMessageListActionHandler implements ActionHandler<GetMessageListAction, GetMessageListResult>
{
    @Inject
    MessagingService messagingService;

    public GetMessageListResult execute(GetMessageListAction arg0, ExecutionContext arg1) throws DispatchException
    {
        return new GetMessageListResult(Lists.newArrayList(messagingService.getMessages()));
    }

    public Class<GetMessageListAction> getActionType()
    {
        return GetMessageListAction.class;
    }

    public void rollback(GetMessageListAction arg0, GetMessageListResult arg1, ExecutionContext arg2)
            throws DispatchException
    {
    }
}