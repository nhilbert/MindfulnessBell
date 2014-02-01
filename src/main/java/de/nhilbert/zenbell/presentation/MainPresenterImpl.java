package de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.model.Settings;
import de.nhilbert.zenbell.views.SettingsForm;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by norman.hilbert on 27.01.14.
 */
@Service
public class MainPresenterImpl implements MainPresenter{

    BellMaster myBellMaster;
    Settings mySettings;

    @Autowired
    public MainPresenterImpl(BellMaster myBellMaster, Settings mySettings) {
        this.myBellMaster = myBellMaster;
        this.mySettings = mySettings;
    }


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
        return mySettings.getBackgroundImage();
    }


    @Override
    public void load() {

    }



    @Override
    public void ring(){
        System.out.println("Let's ring");
        myBellMaster.ring();
    }

    @Override
    public void close() {
        System.out.println("Shutdown!");
        myBellMaster.stop();
    }

    @Override
    public void changeBackground() {

    }

    @Override
    public void showInfo() {

    }

    @Override
    public void showSettings() {
        System.out.println("Trying to show settings dialog");
        SettingsPresenter mySPresenter=new SettingsPresenterImpl();
        SettingsForm mySettingsForm=new SettingsForm(mySPresenter);

    }


}
