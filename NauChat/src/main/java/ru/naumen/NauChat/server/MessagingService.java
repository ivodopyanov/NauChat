/*$Id$*/
package ru.naumen.NauChat.server;

import java.util.List;

/**
 * Сервис, предоставляющий методы для работы со списком сообщений
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface MessagingService
{
    List<String> getMessages();
}