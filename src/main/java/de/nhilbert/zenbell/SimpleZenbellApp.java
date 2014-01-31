package de.nhilbert.zenbell;

import de.nhilbert.zenbell.model.*;
import de.nhilbert.zenbell.presentation.MainPresenter;
import de.nhilbert.zenbell.presentation.MainPresenterImpl;
import de.nhilbert.zenbell.views.BasicMainWindow;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by norman.hilbert on 31.01.14.
 * Package: de.nhilbert.zenbell
 *
 * This is the main Application
 */
public class SimpleZenbellApp {

    public static void main(String [] args){
        Settings MySettings=new SampleSettingsImpl();
        BellMaster myBellMaster=new BasicBellMasterImpl(MySettings);
        myBellMaster.registerBell(new ConsoleBell());
        try{
            myBellMaster.registerBell(new StandardBell("resources/bell.wav"));
        }
        catch(Exception e){
            System.out.println("File not found :-(");
        }
        MainPresenter MyMainPresenter=new MainPresenterImpl(myBellMaster, MySettings);
        BasicMainWindow MyMainWindow = new BasicMainWindow(MyMainPresenter);
        MyMainWindow.showView();

    }
}
