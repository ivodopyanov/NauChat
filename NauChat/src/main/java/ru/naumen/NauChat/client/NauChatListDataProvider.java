/*$Id$*/
package ru.naumen.NauChat.client;

import java.util.Arrays;

import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

/**
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class NauChatListDataProvider extends AsyncDataProvider<String>
{
    @Override
    protected void onRangeChanged(HasData<String> display)
    {
        display.setRowData(0, Arrays.asList("Message3", "Message2", "Message3", "Message4"));
        display.setRowCount(4);
    }
}