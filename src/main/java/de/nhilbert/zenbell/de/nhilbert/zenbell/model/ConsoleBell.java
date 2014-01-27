package de.nhilbert.zenbell.de.nhilbert.zenbell.model;


/**
 * Created by norman.hilbert on 27.01.14.
 */
public class ConsoleBell implements Ringable {

    @Override
    public void ring() {
        System.out.println("Hello World!");
    }
}
