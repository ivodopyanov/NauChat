/*$Id$*/
package ru.naumen.NauChat.server;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Реализация @MessagingService - пока просто при каждом вызове добавляет новое сообщение MessageXXX
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class MessagingServiceImpl implements MessagingService
{
    private final List<String> messages = Lists.newArrayList();

    public List<String> getMessages()
    {
        messages.add("Message" + messages.size());
        return messages;
    }

}
