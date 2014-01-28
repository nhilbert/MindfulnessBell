package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import java.util.TimerTask;


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

    public void testTimerTriggersEvent() throws Exception {
        Settings mySettings =mock(Settings.class);
        Ringable MyBell=mock(Ringable.class);
        when(mySettings.getPeriod()).thenReturn((long) 1000);
        BellMaster myMaster=new BasicBellMasterImpl(mySettings); //create new Bell-Timer
        myMaster.registerBell(MyBell);
        myMaster.ring();
        verify(MyBell).ring();
    }


}
