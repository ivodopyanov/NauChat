/*$Id$*/
package ru.naumen.nauchat.client;

import ru.naumen.nauchat.client.resources.NauChatListResources;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Реализация дисплея. Для задания расположения виджетов использует UiBinder (поэтому унаследован от Composite). 
 * Согласно паттерну MVP дисплей должен быть максимально простым и содержать минимум логики - только геттеры\сеттеры
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatDisplayImpl extends Composite implements NauChatDisplay
{
    /**
     * UiBinder для этого класса. Поскольку нет аннотации @UiTemplate, то по умолчанию берет файл classname.ui.xml 
     * @author ivodopyanov
     */
    static interface NauChatDisplayImplUiBinder extends UiBinder<Panel, NauChatDisplayImpl>
    {
    }

    private static NauChatDisplayImplUiBinder uiBinder = GWT.create(NauChatDisplayImplUiBinder.class);

    @UiField
    DecoratorPanel decorator;

    @UiField
    ScrollPanel panel;

    /**
     * provided=true указывает на то, что этот виджет обязуемся проинициализировать до вызова uiBInder.createAndBindUi
     */
    @UiField(provided = true)
    CellList<String> list;

    @UiField
    TextBox textBox;

    @UiField
    Button sendButton;

    @Inject
    public NauChatDisplayImpl(@Named(NAU_CHAT_CELL_CODE) Cell<String> cell, NauChatListResources listResources)
    {
        list = new CellList<String>(cell, listResources);
        list.setPageSize(Integer.MAX_VALUE);
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public HasData<String> getList()
    {
        return list;
    }

    @Override
    public HasClickHandlers getSendButton()
    {
        return sendButton;
    }

    @Override
    public HasValue<String> getTextBox()
    {
        return textBox;
    }

    /**
     * startProcessing предназначен для вызова при выполнении длительного метода (например, запрос на сервер),
     * чтобы заблокировать возможность повторного вызова
     */
    @Override
    public void startProcessing()
    {
        textBox.setEnabled(false);
    }

    /**
     * stopProcessing предназначен для вызова по окончании работы длительного метода, чтобы разблокировать дисплей
     */
    @Override
    public void stopProcessing()
    {
        textBox.setEnabled(true);
        textBox.setValue("");
        panel.scrollToBottom();
    }
}