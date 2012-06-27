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
    static interface NauChatDisplayImplUiBinder extends UiBinder<FlowPanel, NauChatDisplayImpl>
    {
    }

    private static NauChatDisplayImplUiBinder uiBinder = GWT.create(NauChatDisplayImplUiBinder.class);

    @UiField
    FlowPanel panel;
    /**
     * provided=true указывает на то, что этот виджет обязуемся проинициализировать до вызова uiBInder.createAndBindUi
     */
    @UiField(provided = true)
    CellList<String> list;
    @UiField
    TextBox textBox;

    @Inject
    public NauChatDisplayImpl(@Named(NAU_CHAT_CELL_CODE) Cell<String> cell, NauChatListResources listResources)
    {
        list = new CellList<String>(cell, listResources);
        initWidget(uiBinder.createAndBindUi(this));
    }

    public HasData<String> getList()
    {
        return list;
    }

    public HasValue<String> getTextBox()
    {
        return textBox;
    }

    /**
     * startProcessing предназначен для вызова при выполнении длительного метода (например, запрос на сервер),
     * чтобы заблокировать возможность повторного вызова
     */
    public void startProcessing()
    {
        textBox.setEnabled(false);
    }

    /**
     * stopProcessing предназначен для вызова по окончании работы длительного метода, чтобы разблокировать дисплей
     */
    public void stopProcessing()
    {
        textBox.setEnabled(true);
    }
}