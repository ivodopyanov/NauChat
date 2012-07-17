/*$Id$*/
package ru.naumen.nauchat.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import ru.naumen.nauchat.shared.action.GetMessageListAction;
import ru.naumen.nauchat.shared.action.MessageListResult;
import ru.naumen.nauchat.shared.message.ChatMessage;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;

/**
 * Класс, отвечающий за получение данных, отображаемых в CellList или CellTable, в асинхронном режиме.
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class NauChatListDataProvider extends AsyncDataProvider<String>
{
    public static class RangeChangedCallback implements AsyncCallback<MessageListResult>
    {
        private final HasData<String> display;

        public RangeChangedCallback(HasData<String> display)
        {
            this.display = display;
        }

        @Override
        public void onFailure(Throwable caught)
        {
            GWT.log("Exception while executing GetMessageListAction: " + caught.getMessage());
            display.setRowCount(0);
        }

        @Override
        public void onSuccess(MessageListResult result)
        {
            display.setRowData(0, Lists.transform(result.getMessages(), new Function<ChatMessage, String>()
            {
                @Override
                public String apply(ChatMessage message)
                {
                    return message.getMessageText();
                }
            }));
            display.setRowCount(result.getMessages().size());
        }
    }

    @Inject
    DispatchAsync dispatch;

    @Override
    protected void onRangeChanged(HasData<String> display)
    {
        dispatch.execute(new GetMessageListAction(), new RangeChangedCallback(display));
    }
}