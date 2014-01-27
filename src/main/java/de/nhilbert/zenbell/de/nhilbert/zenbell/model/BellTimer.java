package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import java.util.TimerTask;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This provides an interface for a repeatable timer. It can e.g. be based on the standard JAVA timer class
 * It provides a simple interface, namely the ability to schedule. In addition it provides a method to schedule
 * the timer with a random +/- time interval
 */
public interface BellTimer {
    void schedule(TimerTask task, long period, long randomOffset);
    void cancel();
}
