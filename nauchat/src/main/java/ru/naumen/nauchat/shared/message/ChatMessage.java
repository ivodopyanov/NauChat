package ru.naumen.nauchat.shared.message;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface ChatMessage extends IsSerializable, Serializable
{
    String getMessageText();
}
