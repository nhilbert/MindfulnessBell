package de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.model.Settings;
import de.nhilbert.zenbell.views.SettingsForm;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by norman.hilbert on 27.01.14.
 * This is an implementation of the main presenter.
 * It provides all functionality to the main Window.
 */
@Service
public class MainPresenterImpl implements MainPresenter{

    BellMaster myBellMaster;
    Settings mySettings;

    /**
     * This is the constructor, adding a bellmaster for ringing and a set of settings.
     * @param myBellMaster an implementation of the bellmaster
     * @param mySettings some settings
     */
    @Autowired
    public MainPresenterImpl(BellMaster myBellMaster, Settings mySettings) {
        this.myBellMaster = myBellMaster;
        this.mySettings = mySettings;
    }


    /**
     * Returns the seconds-part of the time left to next ring
     * @return seconds left to next ring
     */
    @Override
    public Integer timeLeftSeconds() {
        return myBellMaster.SecondsLeft()-timeLeftMinutes();
    }

    /**
     * Returns the minutes part of the time left to next ring
     * @return minutes left to next ring
     */
    @Override
    public Integer timeLeftMinutes() {
        return myBellMaster.SecondsLeft()/60;
    }

    /**Returns whether the "mute" function is on or off
     * @return true if sounds are muted, false if sounds play
     */
    @Override
    public Boolean IsMuted() {
        return false;
    }

    /**
     * Returngs a path to the background image
     * @return a path and filename
     */
    @Override
    public String getBackgroundImagePath() {
        return mySettings.getBackgroundImage();
    }

    /**
     * Load date from the data classes
     */
    @Override
    public void load() {

    }

    /**
     * Ring the bell NOW
     */
    @Override
    public void ring(){
        System.out.println("Let's ring");
        myBellMaster.ring();
    }

    /**
     * Prepare the application for closing.
     * Stop the bellmaster
     */
    @Override
    public void close() {
        System.out.println("Shutdown!");
        myBellMaster.stop();
    }

    /**
     * Should show a dialogue
     */
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
