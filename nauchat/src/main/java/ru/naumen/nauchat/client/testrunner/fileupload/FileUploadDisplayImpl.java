/**
 * 
 */
package ru.naumen.nauchat.client.testrunner.fileupload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class FileUploadDisplayImpl extends Composite implements FileUploadDisplay
{

    static interface FileUploadDisplayImplUiBinder extends UiBinder<FormPanel, FileUploadDisplayImpl>
    {
    }

    private static final FileUploadDisplayImplUiBinder uiBinder = GWT.create(FileUploadDisplayImplUiBinder.class);

    @UiField
    FormPanel form;
    @UiField
    FileUpload fileSelect;
    @UiField
    Button fileUpload;

    public FileUploadDisplayImpl()
    {
        initWidget(uiBinder.createAndBindUi(this));
        fileSelect.getElement().setPropertyString("accept", "text/x-java-source");
    }

    @Override
    public FileUpload getFileSelect()
    {
        return fileSelect;
    }

    @Override
    public Button getFileUploadButton()
    {
        return fileUpload;
    }

    @Override
    public FormPanel getFormPanel()
    {
        return form;
    }

    @Override
    public void startProcessing()
    {
        fileSelect.setEnabled(false);
        fileUpload.setEnabled(false);
    }

    @Override
    public void stopProcessing()
    {
        fileSelect.setEnabled(true);
        fileUpload.setEnabled(true);
    }
}