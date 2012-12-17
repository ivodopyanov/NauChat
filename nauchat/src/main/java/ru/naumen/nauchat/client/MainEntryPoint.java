/* $Id$ */
package ru.naumen.nauchat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Класс, с которого начинается выполнение клиентского кода. Указан в
 * NauChat.gwt.xml.
 * 
 * @author ivodopyanov
 * 
 */
public class MainEntryPoint implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        MainGinjector injector = GWT.create(MainGinjector.class);
        injector.resources().nauChatCss().ensureInjected();
        try
        {
            injector.nauChatPresenter().bind();
            injector.playerPresenter().bind();
        }
        catch (Exception e)
        {
            Window.alert("e " + e.getMessage());
        }
        RootPanel.get().add(injector.checkLoginPresenter().getDisplay());
    }
}
