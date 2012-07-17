package ru.naumen.nauchat.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import ru.naumen.nauchat.shared.message.ChatMessage;

public class SendMessageAction implements Action<MessageListResult>
{
    private ChatMessage newMessage;

    public SendMessageAction()
    {
    }

    public SendMessageAction(ChatMessage message)
    {
        setNewMessage(message);
    }

    public ChatMessage getNewMessage()
    {
        return newMessage;
    }

    public void setNewMessage(ChatMessage newMessage)
    {
        this.newMessage = newMessage;
    }
}