package de.nhilbert.zenbell.de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.de.nhilbert.zenbell.views.View;

/**
 * Created by norman.hilbert on 27.01.14.
 * This is the interface for a standard presenter, which makes data available to a view
 */
public interface SettingsPresenter {
    Object getProperty(int PropertyID);
    void setProperty(int PropertyID, Object value);
    void registerView(View v);
    void load();
    void save();
    void saveSettings();
}
