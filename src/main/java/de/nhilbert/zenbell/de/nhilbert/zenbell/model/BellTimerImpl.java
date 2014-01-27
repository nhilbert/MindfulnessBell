package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class BellTimerImpl extends Timer implements BellTimer{
    @Override
    public void schedule(TimerTask task, long period, long randomOffset) {
        super.schedule(task, period, period);
    }
}
