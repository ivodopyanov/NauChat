/*$Id$*/
package ru.naumen.NauChat.server;

import java.util.List;

import ru.naumen.NauChat.shared.message.ChatMessage;
import ru.naumen.NauChat.shared.message.ChatMessageImpl;

import com.google.common.collect.Lists;

/**
 * Реализация @MessagingService - пока просто при каждом вызове добавляет новое сообщение MessageXXX
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class MessagingServiceImpl implements MessagingService
{
    private final List<ChatMessage> messages = Lists.newArrayList();

    @Override
	public List<ChatMessage> getMessages()
    {
        messages.add(new ChatMessageImpl("Message" + messages.size()));
        return messages;
    }
}
