package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.de.nhilbert.zenbell.model.Ringable;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.Command;

import java.util.Collection;

/**
 * Created by norman.hilbert on 30.01.14.
 * Package: de.nhilbert.zenbell.de.nhilbert.zenbell.presentation
 */
public class MuteCommand implements Command {

    Collection<Ringable> ringers;

    public MuteCommand(Collection<Ringable> b) {
        ringers=b;
    }

    @Override
    public boolean execute() {
        for(Ringable bell:myBells ){
            bell.mute();
        }
    }
}
