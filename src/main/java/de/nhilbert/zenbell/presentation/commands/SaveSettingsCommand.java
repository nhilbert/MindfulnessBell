package de.nhilbert.zenbell.presentation.commands;

import de.nhilbert.zenbell.presentation.Command;
import de.nhilbert.zenbell.presentation.SettingsPresenter;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class SaveSettingsCommand implements Command {

    private SettingsPresenter myPresenter;

    public SaveSettingsCommand(SettingsPresenter myPresenter) {
        this.myPresenter=myPresenter;

    }

    @Override
    public boolean execute() {

        return true;
    }
}
