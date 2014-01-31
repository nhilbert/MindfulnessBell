package de.nhilbert.zenbell.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;


/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This test the bell master
 *
 * Timer should trigger an event after given time.
 */
public class BellMasterImplTest extends TestCase {

    Boolean EventTriggered=false;
    int EventCounter=0;

    public void testBellMasterRing() throws Exception {
        Settings mySettings =mock(Settings.class);
        Ringable MyBell=mock(Ringable.class);
        when(mySettings.getPeriod()).thenReturn(10);
        BellMaster myMaster=new BasicBellMasterImpl(mySettings); //create new Bell-Timer
        myMaster.registerBell(MyBell);
        myMaster.ring();
        verify(MyBell).ring();
    }


    public void testTimerTriggersEvent() throws Exception {
        Settings mySettings =mock(Settings.class);
        Ringable MyBell=mock(Ringable.class);
        when(mySettings.getPeriod()).thenReturn(2);
        BellMaster myMaster=new BasicBellMasterImpl(mySettings); //create new Bell-Timer
        myMaster.registerBell(MyBell);
        myMaster.start();
        verify(MyBell, never()).ring();
        reset(MyBell);
        verify(MyBell,never()).ring();
        Thread.sleep(mySettings.getPeriod()*1000);
        verify(MyBell).ring();
        reset(MyBell);
        verify(MyBell,never()).ring();
        Thread.sleep(mySettings.getPeriod()*1000);
        verify(MyBell).ring();
    }

    public void testNoEventAfterStop() throws Exception {
        Settings mySettings =mock(Settings.class);
        Ringable MyBell=mock(Ringable.class);
        when(mySettings.getPeriod()).thenReturn(2);
        BellMaster myMaster=new BasicBellMasterImpl(mySettings); //create new Bell-Timer
        myMaster.registerBell(MyBell);
        myMaster.start();
        myMaster.stop();
        Thread.sleep(mySettings.getPeriod()*2*1000);
        verify(MyBell, never()).ring();
    }

    public void testTimeLeft() throws Exception {
        Settings mySettings =mock(Settings.class);
        Ringable MyBell=mock(Ringable.class);
        when(mySettings.getPeriod()).thenReturn(10);
        BellMaster myMaster=new BasicBellMasterImpl(mySettings); //create new Bell-Timer
        myMaster.registerBell(MyBell);
        myMaster.start();
        Assert.assertEquals("TimeLeft not as expected",10,myMaster.SecondsLeft());
        Thread.sleep(3*1000); //wait 3 sec
        Assert.assertEquals("TimeLeft not as expected",7,myMaster.SecondsLeft());
    }






}
