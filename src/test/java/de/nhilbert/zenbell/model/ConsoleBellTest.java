package de.nhilbert.zenbell.model;

import junit.framework.TestCase;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class ConsoleBellTest extends TestCase {
    public void testRing() throws Exception {
        Ringable myBell = new ConsoleBell();
        myBell.ring();

    }
}
