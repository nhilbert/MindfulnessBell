package de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.presentation.MainPresenter;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by norman.hilbert on 27.01.14.
 * This class listens to the actions in the main window and creates commands for the presentation layer.
 */
public class MainWindowListener implements WindowListener {

    private MainPresenter presenter;

    public MainWindowListener(MainPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
        presenter.close();

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
