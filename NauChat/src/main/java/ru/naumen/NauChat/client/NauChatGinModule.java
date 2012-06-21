/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatGinModule extends AbstractGinModule
{

    @Override
    protected void configure()
    {
        bind(NauChatDisplay.class).to(NauChatDisplayImpl.class);
        bind(EventBus.class).to(DefaultEventBus.class);
    }
}