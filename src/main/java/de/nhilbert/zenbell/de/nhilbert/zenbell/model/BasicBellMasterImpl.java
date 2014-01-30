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
    private Integer TimeLeft;


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
        period=mySettings.getPeriod(); //set Period (in case it changed)
        TimeLeft=period;
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimeLeft--;   //reduce TimeLeft by one
                if(TimeLeft<=0){   //if no time left, ring bell and reset time left.
                    TimeLeft=period;
                    ring();
                }
            }
        }, 0, 1000);  //tick every second = 1000 millisecs
    }

    @Override
    public void stop() {
        myTimer.cancel();
    }

    @Override
    public int SecondsLeft() {
        return TimeLeft;
    }

}
