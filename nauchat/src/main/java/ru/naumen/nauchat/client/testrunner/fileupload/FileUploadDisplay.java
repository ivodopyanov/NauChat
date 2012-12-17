/**
 * 
 */
package ru.naumen.nauchat.client.testrunner.fileupload;

import net.customware.gwt.presenter.client.Display;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public interface FileUploadDisplay extends Display
{
    FileUpload getFileSelect();

    Button getFileUploadButton();

    FormPanel getFormPanel();
}