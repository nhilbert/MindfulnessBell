package de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.presentation.Command;

import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class QuitCommand implements Command {

    private Window source;

    public QuitCommand(Window source) {
        this.source=source;
    }

    @Override
    public boolean execute() {
        WindowEvent wev = new WindowEvent(source, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        return true;
    }
}
