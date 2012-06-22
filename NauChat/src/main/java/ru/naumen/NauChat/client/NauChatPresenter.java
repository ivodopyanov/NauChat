/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;

import com.google.inject.Inject;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatPresenter extends BasicPresenter<NauChatDisplay>
{
    @Inject
    NauChatListDataProvider dataProvider;

    @Inject
    public NauChatPresenter(NauChatDisplay display, EventBus eventBus)
    {
        super(display, eventBus);
    }

    @Override
    public Place getPlace()
    {
        return null;
    }

    public void refreshDisplay()
    {
    }

    public void revealDisplay()
    {
    }

    @Override
    protected void onBind()
    {
        dataProvider.addDataDisplay(getDisplay().getList());
        getDisplay().getTextBox().setValue("NauChat");
    }

    @Override
    protected void onPlaceRequest(PlaceRequest request)
    {
    }

    @Override
    protected void onUnbind()
    {
    }
}