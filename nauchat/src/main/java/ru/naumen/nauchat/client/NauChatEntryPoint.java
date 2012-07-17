/*$Id$*/
package ru.naumen.nauchat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Класс, с которого начинается выполнение клиентского кода. Указан в NauChat.gwt.xml.
 * @author ivodopyanov
 *
 */
public class NauChatEntryPoint implements EntryPoint
{
    @Override
	public void onModuleLoad()
    {
        NauChatGinjector injector = GWT.create(NauChatGinjector.class);
        injector.resources().nauChatCss().ensureInjected();
        
        try
        {
        injector.nauChatPresenter().bind();
        } catch(Exception e)
        {
        	Window.alert("e " + e.getMessage());
        }
        RootPanel.get().add(injector.checkLoginPresenter().getDisplay());
    }
}
