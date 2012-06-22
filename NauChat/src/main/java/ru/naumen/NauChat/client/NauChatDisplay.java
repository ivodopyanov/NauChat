/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.presenter.client.Display;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public interface NauChatDisplay extends Display, IsWidget
{
    String NAU_CHAT_CELL_CODE = "nauChatCellCode";

    HasValue<String> getTextBox();
}