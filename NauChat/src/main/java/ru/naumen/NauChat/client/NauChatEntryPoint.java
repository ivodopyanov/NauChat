package ru.naumen.NauChat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

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
