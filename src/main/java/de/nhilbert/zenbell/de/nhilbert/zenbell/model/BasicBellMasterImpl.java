package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.TimerTask;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This is an Implementation of the BellMaster
 */
public class BasicBellMasterImpl implements BellMaster {

    private BellTimer myTimer;
    private Settings mySettings;

    private Collection<Ringable> myBells;

    public BasicBellMasterImpl(BellTimer myTimer, Settings mySettings) {
        this.myTimer = myTimer;
        this.mySettings = mySettings;
        this.myBells = myBells;
    }

    @Override
    public void registerBell(Ringable bell) {
        myBells.add(bell);

    }

    @Override
    public void reset() {
        stop();
        start();
    }

    @Override
    public void ring() {
        for(Ringable bell:myBells ){
            bell.ring();
        }

    }

    @Override
    public void start() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ring();
            }
        }, mySettings.getPeriod(), 0);
    }

    @Override
    public void stop() {
        myTimer.cancel();
    }
}
