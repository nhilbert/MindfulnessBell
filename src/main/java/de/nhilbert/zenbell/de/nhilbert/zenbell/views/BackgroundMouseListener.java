package de.nhilbert.zenbell.de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands.RingBellCommand;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands.ShowContextMenuCommand;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class BackgroundMouseListener implements MouseListener, CommandCreator {

    private CommandManager myCommandManager;

    public BackgroundMouseListener(CommandManager cm) {
        this.myCommandManager = cm;
    }

    @Override
    public void setManager(CommandManager cm) {
        this.myCommandManager = cm;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        myCommandManager.add(new RingBellCommand(myCommandManager));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //on right click show popup
        if (e.isPopupTrigger()) myCommandManager.add(new ShowContextMenuCommand(e.getComponent(),e.getX(),e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
