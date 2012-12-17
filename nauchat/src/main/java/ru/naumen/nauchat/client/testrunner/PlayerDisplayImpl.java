/**
 * 
 */
package ru.naumen.nauchat.client.testrunner;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author ivodopyanov
 * @since 17.12.2012
 * 
 */
public class PlayerDisplayImpl extends Composite implements PlayerDisplay
{
    static interface PlayerDisplayImplUiBinder extends UiBinder<FlowPanel, PlayerDisplayImpl>
    {
    }

    private static PlayerDisplayImplUiBinder uiBinder = GWT.create(PlayerDisplayImplUiBinder.class);

    @UiField
    FlowPanel panel;

    public PlayerDisplayImpl()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public FlowPanel getPanel()
    {
        return panel;
    }

    @Override
    public void startProcessing()
    {
    }

    @Override
    public void stopProcessing()
    {
    }
}