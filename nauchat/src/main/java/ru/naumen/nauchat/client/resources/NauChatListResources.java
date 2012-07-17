/*$Id$*/
package ru.naumen.nauchat.client.resources;

import com.google.gwt.user.cellview.client.CellList.Resources;
import com.google.gwt.user.cellview.client.CellList.Style;

/**
 * Переопределение ресурсов, используемых для списка list в NauChatDisplayImpl.
 * Позволяет переопределить стили, накладываемые на этот виджет, в файле NauChatList.css
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface NauChatListResources extends Resources
{
    @Source({ Style.DEFAULT_CSS, "NauChatList.css" })
    Style cellListStyle();
}