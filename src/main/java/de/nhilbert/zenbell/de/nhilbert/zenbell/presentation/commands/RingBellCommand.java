package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.Command;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;

/**
 * Created by norman.hilbert on 27.01.14.
 * This command executes the bell ring.
 */
public class RingBellCommand implements Command {

    CommandManager cm;

    //This needs a MainPresenter in order to ring the bell.
    public RingBellCommand(CommandManager cm) {
        this.cm=cm;
    }


    @Override
    public boolean execute() {
        cm.ring();
        return true;
    }
}
