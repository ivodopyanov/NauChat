/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import ru.naumen.NauChat.shared.GetMessageListAction;
import ru.naumen.NauChat.shared.GetMessageListResult;
import ru.naumen.NauChat.shared.message.ChatMessage;

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
    private static class RangeChangedCallback implements AsyncCallback<GetMessageListResult>
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
		public void onSuccess(GetMessageListResult result)
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