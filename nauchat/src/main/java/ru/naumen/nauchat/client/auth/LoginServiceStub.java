package ru.naumen.nauchat.client.auth;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Класс-заглушка для аутентификации
 * @author astarovoyt
 * 
 */
public class LoginServiceStub implements LoginService
{

    @Override
    public void checkLogin(String login, String password, AsyncCallback<Void> result)
    {
        result.onSuccess(null);
    }

    @Override
    public String getLogin()
    {
        return "anonymous";
    }
}
