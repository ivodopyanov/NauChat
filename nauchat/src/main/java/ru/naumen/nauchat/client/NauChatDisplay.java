/*$Id$*/
package ru.naumen.nauchat.client;

import net.customware.gwt.presenter.client.Display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

/**
 * Интерфейс дисплея, в котором есть список сообщений и поле для ввода нового сообщения.
 * @author ivodopyanov
 * @since 20.06.2012
 */
public interface NauChatDisplay extends Display, IsWidget
{
    String NAU_CHAT_CELL_CODE = "nauChatCellCode";

    HasData<String> getList();

    HasValue<String> getTextBox();
    
    HasClickHandlers getSendButton();
}