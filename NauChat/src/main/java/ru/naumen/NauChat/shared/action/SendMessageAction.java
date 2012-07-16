package ru.naumen.NauChat.shared.action;

import net.customware.gwt.dispatch.shared.Action;
import ru.naumen.NauChat.shared.message.ChatMessage;

public class SendMessageAction implements Action<MessageListResult>
{
	private ChatMessage newMessage;
	
	public SendMessageAction(ChatMessage message)
	{
		setNewMessage(message);
	}
	
    public SendMessageAction()
    {
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