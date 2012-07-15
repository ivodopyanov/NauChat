/*$Id$*/
package ru.naumen.NauChat.shared;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;
import ru.naumen.NauChat.shared.message.ChatMessage;

import com.google.common.collect.Lists;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class GetMessageListResult implements Result
{
    private ArrayList<ChatMessage> messages;

    public GetMessageListResult(ArrayList<ChatMessage> messages)
    {
        super();
        this.messages = messages;
    }

    protected GetMessageListResult()
    {
    }

    public List<ChatMessage> getMessages()
    {
        if (messages == null)
        {
            messages = Lists.newArrayList();
        }
        return messages;
    }

    public void setMessages(ArrayList<ChatMessage> messages)
    {
        this.messages = messages;
    }
}