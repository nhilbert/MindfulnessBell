package de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.model.Settings;
import de.nhilbert.zenbell.views.View;
import org.springframework.stereotype.Service;

/**
 * Created by norman.hilbert on 27.01.14.
 */
@Service
public class SettingsPresenterImpl implements SettingsPresenter {

    private String backgroundImage;
    private Boolean notificationEnabled;
    private Boolean isMuted;
    private Integer periodSec;
    private Integer periodMin;

    Settings mySettings;



    @Override
    public void saveSettings() {
        save();
    }

    @Override
    public void save() {
        mySettings.setBackgroundImage(backgroundImage);
        mySettings.setPeriodMin(periodMin);
        mySettings.setPeriodSec(periodSec);
        if(isMuted) mySettings.Mute();
        else mySettings.Unmute();
        if(notificationEnabled) mySettings.enableNotification();
        else mySettings.disableNotification();

        load();
    }

    @Override
    public void load(){
        backgroundImage =mySettings.getBackgroundImage();
        periodMin=mySettings.getPeriodMin();
        periodSec=mySettings.getPeriodSec();
        isMuted=mySettings.isMuted();
        notificationEnabled =mySettings.NotificationEnabled();
    }

    @Override
    public Object getProperty(int PropertyID) {
        switch(PropertyID){
            case WindowProperties.BGIMAGE:
                return backgroundImage;
            case WindowProperties.PERIODSEC:
                return periodMin;
            case WindowProperties.PERIODMIN:
                return periodSec;
            case WindowProperties.MUTED:
                return isMuted;
            case WindowProperties.NOTIFIER:
                return notificationEnabled;
            default:
                return null;
        }
    }

    @Override
    public void setProperty(int PropertyID, Object value) {
        switch(PropertyID){
            case WindowProperties.BGIMAGE:
                backgroundImage=(String) value;
                break;
            case WindowProperties.PERIODSEC:
                periodSec = (Integer) value;
                break;
            case WindowProperties.PERIODMIN:
                periodMin=(Integer) value;
                break;
            case WindowProperties.MUTED:
                isMuted=(Boolean) value;
                break;
            case WindowProperties.NOTIFIER:
                notificationEnabled=(Boolean) value;
        }
    }

    @Override
    public void registerView(View v) {

    }
}
