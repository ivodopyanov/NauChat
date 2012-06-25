/*$Id$*/
package ru.naumen.NauChat.server;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author ivodopyanov
 * @since 22.06.2012
 */
public class MessagingServiceImpl implements MessagingService
{
    private List<String> messages = Lists.newArrayList();

    public List<String> getMessages()
    {
        messages.add("Message" + messages.size());
        return messages;
    }

}
