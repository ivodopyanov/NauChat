/*$Id$*/
package ru.naumen.NauChat.client;

import ru.naumen.NauChat.client.auth.CheckLoginPresenter;
import ru.naumen.NauChat.client.resources.NauChatResources;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Инжектор Google Gin для создания объектов с автоматически разрешенными зависимостями в клиентском коде.
 * Предоставляет методы для создания этих объектов.
 * @author ivodopyanov
 * @since 20.06.2012
 */
@GinModules(NauChatGinModule.class)
public interface NauChatGinjector extends Ginjector
{
    NauChatPresenter nauChatPresenter();

    NauChatResources resources();
    
    CheckLoginPresenter checkLoginPresenter();
}