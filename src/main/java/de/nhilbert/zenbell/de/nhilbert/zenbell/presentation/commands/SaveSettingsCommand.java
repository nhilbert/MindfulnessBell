package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.Command;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class SaveSettingsCommand implements Command {

    private CommandManager cm;

    public SaveSettingsCommand() {

    }

    @Override
    public boolean execute() {

        return true;
    }
}
