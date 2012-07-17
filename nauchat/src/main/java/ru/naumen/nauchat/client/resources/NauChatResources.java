/*$Id$*/
package ru.naumen.nauchat.client.resources;

import ru.naumen.nauchat.client.NauChatCss;

import com.google.gwt.resources.client.ClientBundle;

/**
 * Ресурсы для дисплея @NauChatDisplayImpl. Тут могут быть методы доступа к стилям CSS, изображениям, текстовым файлам и т.д.
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface NauChatResources extends ClientBundle
{
    /**
     * CSS-классы, определенные в NauChat.css, должны строго соответствовать классам в аннотациях @ClassName интерфейса @NauChatCss 
     */
    @Source("NauChat.css")
    NauChatCss nauChatCss();
}