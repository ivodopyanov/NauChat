/**
 * 
 */
package ru.naumen.nauchat.client.auth;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class AuthGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(CheckLoginDisplay.class).to(CheckLoginDisplayImpl.class);
        bind(LoginService.class).to(LoginServiceStub.class);
    }
}