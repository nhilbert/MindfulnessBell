package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.de.nhilbert.zenbell.model.Settings;
import de.nhilbert.zenbell.de.nhilbert.zenbell.views.View;

import java.util.Collection;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class MainPresenterImpl implements MainPresenter{

    Collection<View> ViewList;
    BellMaster myBellMaster;
    Settings mySettings;




    @Override
    public Object getProperty(int PropertyID) {
        switch(PropertyID){
            case WindowProperties.BGIMAGE:
                return mySettings.getBackgroundImage();
            case WindowProperties.TIMELEFTSEC:
                return "15";
            case WindowProperties.TIMELEFTMIN:
                return "15";
            case WindowProperties.TIMELEFTHRS:
                return "15";
            case WindowProperties.MUTED:
                return false;
            case WindowProperties.NOTIFIER:
                return true;
            default:
                return null;
        }

    }

    @Override
    public void setProperty(int PropertyID, Object value) {

    }


    @Override
    public void registerView(View v) {
        ViewList.add(v);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public void ring(){
        myBellMaster.ring();
    }

    @Override
    public void close() {

    }

    @Override
    public void changeBackground() {

    }

    @Override
    public void showInfo() {

    }

    @Override
    public void showSettings() {

    }


}
