/*$Id$*/
package ru.naumen.NauChat.server;

import java.util.List;

/**
 * @author ivodopyanov
 * @since 22.06.2012
 */
public interface MessagingService
{
    List<String> getMessages();
}