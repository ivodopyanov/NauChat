package ru.naumen.nauchat.shared.message;

public class ChatMessageImpl implements ChatMessage
{
	private String messageText;
	
	public ChatMessageImpl()
	{
		
	}
	
	public ChatMessageImpl(String text)
	{
		messageText = text;
	}

	@Override
	public String getMessageText() 
	{
		return messageText;
	}
}
