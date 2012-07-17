package ru.naumen.nauchat.client.auth;

import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.place.PlaceRequestEvent;
import ru.naumen.nauchat.client.NauChatPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

public class CheckLoginPresenter extends BasicPresenter<CheckLoginDisplay>
{

    public static final Place PLACE = new Place("login");
    @Inject
    LoginService loginService;

    @Inject
    public CheckLoginPresenter(CheckLoginDisplay display, EventBus eventBus)
    {
        super(display, eventBus);
        addClickOkHandler(display.getOkButton());
        bind();
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

    @Override
    protected void onBind()
    {

    }

    @Override
    protected void onPlaceRequest(PlaceRequest request)
    {

    }

    @Override
    protected void onUnbind()
    {

    }

    private void addClickOkHandler(HasClickHandlers okButton)
    {
        okButton.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                loginService.checkLogin(getDisplay().getLogin().getValue(), getDisplay().getPassword().getValue(),
                        new AsyncCallback<Void>()
                        {

                            @Override
                            public void onFailure(Throwable caught)
                            {

                            }

                            @Override
                            public void onSuccess(Void result)
                            {
                                // Меняем плейс
                                eventBus.fireEvent(new PlaceRequestEvent(new PlaceRequest(NauChatPresenter.PLACE)));
                            }
                        });
            }
        });
    }
}
