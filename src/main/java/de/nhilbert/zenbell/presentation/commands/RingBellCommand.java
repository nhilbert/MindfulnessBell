package de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.presentation.Command;

/**
 * Created by norman.hilbert on 27.01.14.
 * This command executes the bell ring.
 */
public class RingBellCommand implements Command {

    BellMaster bm;

    //This needs a MainPresenterImpl in order to ring the bell.
    public RingBellCommand(BellMaster bm) {
        this.bm=bm;
    }


    @Override
    public boolean execute() {
        bm.ring();
        return true;
    }
}
