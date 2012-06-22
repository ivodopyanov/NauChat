/*$Id$*/
package ru.naumen.NauChat.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatDisplayImpl extends Composite implements NauChatDisplay
{

    static interface NauChatDisplayImplUiBinder extends UiBinder<FlowPanel, NauChatDisplayImpl>
    {
    }

    private static NauChatDisplayImplUiBinder uiBinder = GWT.create(NauChatDisplayImplUiBinder.class);

    @UiField
    FlowPanel panel;
    CellList<String> list;
    @UiField
    TextBox textBox;

    @Inject
    public NauChatDisplayImpl(@Named(NAU_CHAT_CELL_CODE) Cell<String> cell)
    {
        list = new CellList<String>(cell);
        initWidget(uiBinder.createAndBindUi(this));
        panel.insert(list, 0);
    }

    public HasValue<String> getTextBox()
    {
        return textBox;
    }

    public void startProcessing()
    {
        textBox.setEnabled(false);
    }

    public void stopProcessing()
    {
        textBox.setEnabled(true);
    }
}