package de.nhilbert.zenbell.presentation;

import de.nhilbert.zenbell.views.View;

/**
 * Created by norman.hilbert on 27.01.14.
 * This is the interface for a standard presenter, which makes data available to a view
 */
public interface MainPresenter
{
    Integer timeLeftSeconds();
    Integer timeLeftMinutes();

    Boolean IsMuted();

    String getBackgroundImagePath();


    void registerView(View v);
    void load();

    void ring();

    void close();

    void changeBackground();

    void showInfo();

    void showSettings();
}
