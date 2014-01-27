package de.nhilbert.zenbell.de.nhilbert.zenbell.views;


import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;



/**
 * Created by norman.hilbert on 27.01.14.
 *
 * A basic interface for a view.
 */
public interface View {
    void showView();
    void hideView();
    void updateView();
    void addCommandManager(CommandManager cm);
}
