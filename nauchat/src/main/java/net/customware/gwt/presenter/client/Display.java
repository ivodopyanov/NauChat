/**
 * 
 */
package net.customware.gwt.presenter.client;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public interface Display extends IsWidget
{
    /**
     * Indicate to the display that processing is being done.
     */
    void startProcessing();

    /**
     * Indicate to the display that processing has completed.
     */
    void stopProcessing();
}
