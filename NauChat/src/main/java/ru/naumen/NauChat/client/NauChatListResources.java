/*$Id$*/
package ru.naumen.NauChat.client;

import com.google.gwt.user.cellview.client.CellList.Resources;
import com.google.gwt.user.cellview.client.CellList.Style;

/**
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface NauChatListResources extends Resources
{
    @Source({ Style.DEFAULT_CSS, "NauChatList.css" })
    Style cellListStyle();
}