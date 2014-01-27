package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.ContextMenu;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.Command;

import java.awt.*;


/**
 * Created by norman.hilbert on 27.01.14.
 */
public class ShowContextMenuCommand implements Command {

    Component invoker;
    int x,y;

    public ShowContextMenuCommand(Component invoker, int x, int y){
        this.invoker=invoker;
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean execute() {
        ContextMenu myContextMenu= new ContextMenu();
        myContextMenu.show(invoker,x,y);
        return true;
    }
}
