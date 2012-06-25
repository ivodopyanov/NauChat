/*$Id$*/
package ru.naumen.NauChat.shared;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.google.common.collect.Lists;

/**
 * @author ivodopyanov
 * @since 25.06.2012
 */
public class GetMessageListResult implements Result
{
    private ArrayList<String> messages;

    public GetMessageListResult(ArrayList<String> messages)
    {
        super();
        this.messages = messages;
    }

    protected GetMessageListResult()
    {
    }

    public List<String> getMessages()
    {
        if (messages == null)
            messages = Lists.newArrayList();
        return messages;
    }

    public void setMessages(ArrayList<String> messages)
    {
        this.messages = messages;
    }
}