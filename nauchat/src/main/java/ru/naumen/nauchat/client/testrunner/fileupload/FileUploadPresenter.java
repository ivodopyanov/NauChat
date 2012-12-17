/**
 * 
 */
package ru.naumen.nauchat.client.testrunner.fileupload;

import javax.inject.Inject;

import ru.naumen.nauchat.client.testrunner.PlayerMessages;

import net.customware.gwt.presenter.client.BasicPresenter;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class FileUploadPresenter extends BasicPresenter<FileUploadDisplay>
{
    private final ClickHandler ON_FILE_SELECT = new ClickHandler()
    {
        @Override
        public void onClick(ClickEvent event)
        {
            String fileName = getDisplay().getFileSelect().getFilename();
            if (fileName.isEmpty())
                Window.alert(messages.noFileSelected());
            else
            {
                getDisplay().startProcessing();
                getDisplay().getFormPanel().submit();
            }
        }
    };

    private final FormPanel.SubmitCompleteHandler ON_FILE_UPLOADED = new SubmitCompleteHandler()
    {
        @Override
        public void onSubmitComplete(SubmitCompleteEvent event)
        {
            getDisplay().stopProcessing();
            Window.alert(messages.fileUploadComplete());
        }
    };

    @Inject
    PlayerMessages messages;

    @Inject
    public FileUploadPresenter(FileUploadDisplay display, EventBus eventBus)
    {
        super(display, eventBus);
    }

    @Override
    public Place getPlace()
    {
        return null;
    }

    @Override
    public void refreshDisplay()
    {
    }

    @Override
    public void revealDisplay()
    {
    }

    @Override
    protected void onBind()
    {
        registerHandler(getDisplay().getFileUploadButton().addClickHandler(ON_FILE_SELECT));
        registerHandler(getDisplay().getFormPanel().addSubmitCompleteHandler(ON_FILE_UPLOADED));

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