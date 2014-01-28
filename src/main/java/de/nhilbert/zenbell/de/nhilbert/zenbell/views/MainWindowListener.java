package de.nhilbert.zenbell.de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.MainPresenter;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands.QuitCommand;

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

    }

    @Override
    public void windowClosed(WindowEvent e) {
        presenter.close(); //on closing the window, quit the application

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
