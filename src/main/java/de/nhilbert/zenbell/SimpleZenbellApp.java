package de.nhilbert.zenbell;

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

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        BeanFactory factory = context;

        BasicMainWindow MyMainWindow=new BasicMainWindow();
        MyMainWindow.showView();

    }
}
