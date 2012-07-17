package ru.naumen.nauchat.client.auth;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CheckLoginDisplayImpl extends Composite implements CheckLoginDisplay
{
    static interface LoginUiBinder extends UiBinder<Widget, CheckLoginDisplayImpl>
    {
    }

    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    @UiField
    TextBox username;
    @UiField
    PasswordTextBox password;
    @UiField
    Button login;

    public CheckLoginDisplayImpl()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public HasValue<String> getLogin()
    {
        return username;
    }

    @Override
    public HasClickHandlers getOkButton()
    {
        return login;
    }

    @Override
    public HasValue<String> getPassword()
    {
        return password;
    }

    @Override
    public void startProcessing()
    {

    }

    @Override
    public void stopProcessing()
    {

    }
}
