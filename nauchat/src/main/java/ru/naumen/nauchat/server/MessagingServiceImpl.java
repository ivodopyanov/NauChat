/*$Id$*/
package ru.naumen.nauchat.server;

import java.util.List;

import ru.naumen.nauchat.shared.message.ChatMessage;

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
        return messages;
    }

	@Override
	public List<ChatMessage> addMessage(ChatMessage message) {
        messages.add(message);
        return messages;
	}
}
