package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This is an Interface to a BellMaster
 */
public interface BellMaster {
    void registerBell(Ringable bell);
    void reset();
    void ring();
    void start();
    void stop();

    int SecondsLeft();
}
