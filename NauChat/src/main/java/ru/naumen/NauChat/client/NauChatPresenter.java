/*$Id$*/
package ru.naumen.NauChat.client;

import java.util.Arrays;

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
        getDisplay().getTextBox().setValue("NauChat");
        getDisplay().getList().setRowData(0, Arrays.asList("Message1", "Message2"));
        getDisplay().getList().setRowCount(2, true);
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