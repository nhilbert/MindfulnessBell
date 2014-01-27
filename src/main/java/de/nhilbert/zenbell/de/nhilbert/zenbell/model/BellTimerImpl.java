package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class BellTimerImpl extends Timer implements BellTimer{
    @Override
    public void schedule(TimerTask task, long delay, long period, long randomOffset) {
        this.schedule(task, delay, period);
    }
}
