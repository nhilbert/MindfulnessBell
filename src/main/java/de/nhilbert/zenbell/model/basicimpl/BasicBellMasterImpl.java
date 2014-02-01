package de.nhilbert.zenbell.model.basicimpl;

import de.nhilbert.zenbell.model.BellMaster;
import de.nhilbert.zenbell.model.Ringable;
import de.nhilbert.zenbell.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This is an Implementation of the BellMaster
 */
@Service
public class BasicBellMasterImpl implements BellMaster {

    private Timer myTimer;
    private Settings mySettings;
    private Integer period;
    private Integer TimeLeft;


    private Collection<Ringable> myBells;

    @Autowired
    public BasicBellMasterImpl(Settings mySettings) {
        System.out.println("Creating BellMaster");
        this.myTimer = new Timer();
        this.mySettings = mySettings;
        this.myBells = new LinkedList<Ringable>();
        this.start();
    }

    @Override
    public void registerBell(Ringable bell) {
        myBells.add(bell);
        System.out.println("Registering new bell:"+bell.toString());

    }

    @Override
    public void reset() {
        System.out.println("Resetting bell master");
        stop();
        start();
    }

    @Override
    public void ring() {
        System.out.println("Ring!");
        for(Ringable bell:myBells ){
            System.out.println("Ringing: "+bell.toString());
            bell.ring();
        }

    }

    @Override
    public void start() {
        period=mySettings.getPeriod(); //set Period (in case it changed)
        System.out.println("Staring Bell Master with period "+period);
        TimeLeft=period;
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimeLeft--;   //reduce TimeLeft by one
                System.out.println(TimeLeft +" seconds left to next ring.");
                if(TimeLeft<=0){   //if no time left, ring bell and reset time left.
                    TimeLeft=period;
                    ring();
                }
            }
        }, 0, 1000);  //tick every second = 1000 millisecs
    }

    @Override
    public void stop() {
        System.out.println("Stopping BellMaster.");
        myTimer.cancel();
    }

    @Override
    public int SecondsLeft() {
        return TimeLeft;
    }

}
