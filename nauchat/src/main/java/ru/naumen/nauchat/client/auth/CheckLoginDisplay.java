package ru.naumen.nauchat.client.auth;

import net.customware.gwt.presenter.client.Display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface CheckLoginDisplay extends Display, IsWidget
{
    HasValue<String> getLogin();

    HasClickHandlers getOkButton();

    HasValue<String> getPassword();
}
