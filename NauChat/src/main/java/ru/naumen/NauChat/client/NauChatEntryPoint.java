/*$Id$*/
package ru.naumen.NauChat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Класс, с которого начинается выполнение клиентского кода. Указан в NauChat.gwt.xml.
 * @author ivodopyanov
 *
 */
public class NauChatEntryPoint implements EntryPoint
{
    public void onModuleLoad()
    {
        NauChatGinjector injector = GWT.create(NauChatGinjector.class);
        injector.resources().nauChatCss().ensureInjected();
        NauChatPresenter presenter = injector.nauChatPresenter();
        presenter.bind();
        RootPanel.get().add(presenter.getDisplay());
    }
}
