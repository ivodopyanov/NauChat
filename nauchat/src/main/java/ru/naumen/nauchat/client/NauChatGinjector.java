/*$Id$*/
package ru.naumen.nauchat.client;

import ru.naumen.nauchat.client.auth.CheckLoginPresenter;
import ru.naumen.nauchat.client.resources.NauChatResources;

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
    CheckLoginPresenter checkLoginPresenter();

    NauChatPresenter nauChatPresenter();

    NauChatResources resources();
}