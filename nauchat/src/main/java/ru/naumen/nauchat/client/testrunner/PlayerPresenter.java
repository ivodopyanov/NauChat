/**
 * 
 */
package ru.naumen.nauchat.client.testrunner;

import javax.inject.Inject;

import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import ru.naumen.nauchat.client.testrunner.fileupload.FileUploadPresenter;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class PlayerPresenter extends BasicPresenter<PlayerDisplay>
{
    public static final Place PLACE = new Place("player");

    @Inject
    FileUploadPresenter fileUploadPresenter;

    @Inject
    public PlayerPresenter(PlayerDisplay display, EventBus eventBus)
    {
        super(display, eventBus);
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
        fileUploadPresenter.bind();
        getDisplay().getPanel().add(fileUploadPresenter.getDisplay());
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
