/*$Id$*/
package ru.naumen.NauChat.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
@GinModules(NauChatGinModule.class)
public interface NauChatGinjector extends Ginjector
{
    NauChatPresenter nauChatPresenter();
}