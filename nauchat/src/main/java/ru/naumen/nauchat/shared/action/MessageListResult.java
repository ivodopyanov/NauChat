/*$Id$*/
package ru.naumen.nauchat.shared.action;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;
import ru.naumen.nauchat.shared.message.ChatMessage;

import com.google.common.collect.Lists;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class MessageListResult implements Result
{
    private ArrayList<ChatMessage> messages;

    public MessageListResult(ArrayList<ChatMessage> messages)
    {
        super();
        this.messages = messages;
    }

    protected MessageListResult()
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