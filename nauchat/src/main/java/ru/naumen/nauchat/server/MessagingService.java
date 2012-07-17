/*$Id$*/
package ru.naumen.nauchat.server;

import java.util.List;

import ru.naumen.nauchat.shared.message.ChatMessage;

/**
 * Сервис, предоставляющий методы для работы со списком сообщений
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface MessagingService
{
    List<ChatMessage> getMessages();
    
    List<ChatMessage> addMessage(ChatMessage message);
}