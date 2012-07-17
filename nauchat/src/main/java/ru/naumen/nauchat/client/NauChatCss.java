/*$Id$*/
package ru.naumen.nauchat.client;

import com.google.gwt.resources.client.CssResource;

/**
 * Интерфейс для доступа к CSS для дисплея NauChatDisplayImpl. Конкретный css-файл определяется в @NauChatResources.
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface NauChatCss extends CssResource
{
    @ClassName("inputBox")
    String inputBox();

    @ClassName("panel")
    String panel();
    
    @ClassName("decorator")
    String decorator();
}