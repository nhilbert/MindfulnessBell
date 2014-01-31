package de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.model.Settings;
import de.nhilbert.zenbell.views.BasicMainWindow;
import de.nhilbert.zenbell.views.SettingsForm;
import de.nhilbert.zenbell.views.View;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by norman.hilbert on 27.01.14.
 */
@Service
public class MainPresenterImpl implements MainPresenter{

    Collection<View> ViewList;
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
        System.out.println("Let's ring");
        myBellMaster.ring();
    }

    @Override
    public void close(Window source) {
        System.out.println("Shutdown!");
        WindowEvent wev = new WindowEvent(source, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
    }

    @Override
    public void changeBackground() {

    }

    @Override
    public void showInfo() {

    }

    @Override
    public void showSettings() {
        SettingsPresenter mySPresenter=new SettingsPresenterImpl();
        SettingsForm mySettingsForm=new SettingsForm(mySPresenter);

    }


}
