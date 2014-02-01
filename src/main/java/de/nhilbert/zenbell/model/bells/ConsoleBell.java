package de.nhilbert.zenbell.model.bells;


import de.nhilbert.zenbell.model.Ringable;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class ConsoleBell implements Ringable {

    @Override
    public void ring() {
        System.out.println("Hello World!");
    }


    @Override
    public Boolean isMutable() {
        return false; // not effected by mute
    }

    @Override
    public void mute() {

    }

    @Override
    public void unMute() {

    }

    @Override
    public String toString() {
        return "StandardBell";
    }
}
