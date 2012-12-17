/**
 * 
 */
package ru.naumen.nauchat.client.resources;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class ResourcesGinModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(NauChatResources.class).in(Singleton.class);
        bind(NauChatListResources.class).in(Singleton.class);
    }
}