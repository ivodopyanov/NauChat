/*$Id$*/
package ru.naumen.NauChat.client;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatDisplayImpl extends FlowPanel implements NauChatDisplay
{
    CellList<String> list;
    TextBox textBox;

    public NauChatDisplayImpl()
    {
        add(list);
        add(textBox);
        textBox.setText("NauChat");
    }

    public void startProcessing()
    {
    }

    public void stopProcessing()
    {
    }
}