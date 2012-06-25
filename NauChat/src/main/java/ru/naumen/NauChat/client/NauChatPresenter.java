/*$Id$*/
package ru.naumen.NauChat.client;

import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.inject.Inject;

/**
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatPresenter extends BasicPresenter<NauChatDisplay>
{
    private final static int LIST_REFRESH_PERIOD = 10000;
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
        Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
        {
            public boolean execute()
            {
                dataProvider.onRangeChanged(getDisplay().getList());
                return true;
            }
        }, LIST_REFRESH_PERIOD);
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