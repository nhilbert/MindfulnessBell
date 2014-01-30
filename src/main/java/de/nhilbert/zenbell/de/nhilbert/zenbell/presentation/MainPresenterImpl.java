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
    public Integer timeLeftSeconds() {
        return myBellMaster.SecondsLeft()-timeLeftMinutes();
    }

    @Override
    public Integer timeLeftMinutes() {
        return myBellMaster.SecondsLeft()/60;
    }

    @Override
    public Boolean IsMuted() {
        return false;
    }

    @Override
    public String getBackgroundImagePath() {
        return null;
    }

    @Override
    public void registerView(View v) {
        ViewList.add(v);
    }

    @Override
    public void load() {

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
