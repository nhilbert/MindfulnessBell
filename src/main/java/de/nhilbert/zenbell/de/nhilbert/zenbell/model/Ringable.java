package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

/**
 * Created by norman.hilbert on 27.01.14.
 *
 * This is an interface for a bell. It provides a ring method to do some action.
 */
public interface Ringable {

    /**
     * This provides the action that is supposed to be executed by any bell.
     */
    public void ring();
    public Boolean isMutable();
    public void mute();
    public void unMute();
}
