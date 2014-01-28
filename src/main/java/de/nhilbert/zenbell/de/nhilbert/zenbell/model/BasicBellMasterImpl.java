package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import java.util.*;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This is an Implementation of the BellMaster
 */
public class BasicBellMasterImpl implements BellMaster {

    private Timer myTimer;
    private Settings mySettings;
    private Integer period;

    private Collection<Ringable> myBells;

    public BasicBellMasterImpl(Settings mySettings) {
        this.myTimer = new Timer();
        this.mySettings = mySettings;
        this.myBells = new LinkedList<Ringable>();
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
        }, 0, mySettings.getPeriod());
    }

    @Override
    public void stop() {
        myTimer.cancel();
    }

}
