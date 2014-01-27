package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import junit.framework.Assert;
import junit.framework.TestCase;


import java.util.TimerTask;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This test the bell timer
 *
 * Timer should trigger an event after given time.
 */
public class BellTimerImplTest extends TestCase {

    Boolean EventTriggered=false;
    int EventCounter=0;

    public void testTimerTriggersEvent() throws Exception {
        BellTimer myTimer=new BellTimerImpl(); //create new Bell-Timer

        TimerTask myTask=new TimerTask() {
            @Override
            public void run() {
                EventTriggered=true;
            }
        };
        Assert.assertFalse("Setup failed", EventTriggered);

        myTimer.schedule(myTask,1000,0);
        Assert.assertFalse("Triggered way early", EventTriggered);

        Thread.sleep(550);
        Assert.assertFalse("Triggered early", EventTriggered);
        Thread.sleep(500);
        Assert.assertTrue("Not Triggered", EventTriggered);

    }

    public void testTimerRepeatsInPeriod() throws Exception {
        BellTimer myTimer=new BellTimerImpl(); //create new Bell-Timer

        TimerTask myTask=new TimerTask() {
            @Override
            public void run() {
                EventCounter++;
            }
        };


        myTimer.schedule(myTask,1000,0);


        Thread.sleep(5050);
        Assert.assertEquals("Incorrect Count", EventCounter, 5);

    }
}
