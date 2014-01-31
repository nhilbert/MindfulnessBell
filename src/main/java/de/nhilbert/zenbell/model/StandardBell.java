package de.nhilbert.zenbell.model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by norman.hilbert on 30.01.14.
 * Package: de.nhilbert.zenbell.model
 *
 * This is a standard bell ringing a soundfile
 */
public class StandardBell implements Ringable {

    private Boolean muted=false;
    private File soundfile;

    public StandardBell(String SoundfilePath) throws FileNotFoundException
    {
        soundfile=new File(SoundfilePath);
        if(soundfile.canRead()==false) throw new FileNotFoundException();
    }

    @Override
    public void ring() {
        if(!muted){
            //play sound
            try{ AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundfile.getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                System.out.println("Listen, Listen to this wonderful sound.");
            }catch(Exception ex){
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }

        }
    }

    @Override
    public Boolean isMutable() {
        return true;
    }

    @Override
    public void mute() {
        muted=true;
    }

    @Override
    public void unMute() {
        muted=false;
    }

    @Override
    public String toString() {
        return "StandardBell";
    }
}
