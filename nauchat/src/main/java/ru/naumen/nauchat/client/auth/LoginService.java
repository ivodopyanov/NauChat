package ru.naumen.nauchat.client.auth;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginService
{
    /**
     * @param login - логин
     * @param password - пароль
     * @param result - Возврат результата. Если все хорошо onSuccess,  если ошибка onFailure
     */
    void checkLogin(String login, String password, AsyncCallback<Void> result);

    String getLogin();
}
