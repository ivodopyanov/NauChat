/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import ru.naumen.NauChat.shared.GetMessageListAction;
import ru.naumen.NauChat.shared.GetMessageListResult;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;

/**
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class NauChatListDataProvider extends AsyncDataProvider<String>
{
    @Inject
    DispatchAsync dispatch;

    @Override
    protected void onRangeChanged(final HasData<String> display)
    {
        dispatch.execute(new GetMessageListAction(), new AsyncCallback<GetMessageListResult>()
        {
            public void onFailure(Throwable caught)
            {
                GWT.log("Exception while executing GetMessageListAction: " + caught.getMessage());
                display.setRowCount(0);
            }

            public void onSuccess(GetMessageListResult result)
            {
                display.setRowData(0, result.getMessages());
                display.setRowCount(result.getMessages().size());
            }
        });
    }
}