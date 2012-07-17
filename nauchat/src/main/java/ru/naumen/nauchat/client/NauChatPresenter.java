/*$Id$*/
package ru.naumen.nauchat.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import ru.naumen.nauchat.client.NauChatListDataProvider.RangeChangedCallback;
import ru.naumen.nauchat.shared.action.SendMessageAction;
import ru.naumen.nauchat.shared.message.ChatMessageImpl;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

/**
 * Презентер для дисплея NauChatDisplay. Отвечает за инициализацию дисплея,
 * исходное заполнение данных, а также вызывает обновление списка с
 * периодичностью LIST_REFRESH_PERIOD_MS
 * 
 * @author ivodopyanov
 * @since 20.06.2012
 */
public class NauChatPresenter extends BasicPresenter<NauChatDisplay>
{
    public static final Place PLACE = new Place("nauchat");

    private final static int LIST_REFRESH_PERIOD_MS = 10000;

    @Inject
    NauChatListDataProvider dataProvider;

    @Inject
    DispatchAsync dispatch;

    @Inject
    public NauChatPresenter(NauChatDisplay display, EventBus eventBus)
    {
        super(display, eventBus);
        addSendButtonClickHandler(display.getSendButton());
    }

    public void addSendButtonClickHandler(HasClickHandlers button)
    {
        button.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                sendMessage(getDisplay().getTextBox().getValue());
                getDisplay().getTextBox().setValue("");
            }
        });
    }

    @Override
    public Place getPlace()
    {
        return PLACE;
    }

    @Override
    public void refreshDisplay()
    {
    }

    @Override
    public void revealDisplay()
    {
        RootPanel.get().clear();
        RootPanel.get().add(getDisplay());
    }

    public void sendMessage(String messageText)
    {
        dispatch.execute(new SendMessageAction(new ChatMessageImpl(messageText)), new RangeChangedCallback(getDisplay()
                .getList()));
    }

    @Override
    protected void onBind()
    {
        dataProvider.addDataDisplay(getDisplay().getList());
        getDisplay().getTextBox().setValue("NauChat");

        Scheduler.get().scheduleFixedDelay(new RepeatingCommand()
        {
            @Override
            public boolean execute()
            {
                dataProvider.onRangeChanged(getDisplay().getList());
                return true;
            }
        }, LIST_REFRESH_PERIOD_MS);
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