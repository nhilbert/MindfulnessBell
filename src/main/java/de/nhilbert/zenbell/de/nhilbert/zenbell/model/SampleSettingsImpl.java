package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class SampleSettingsImpl implements Settings{

    private String backgroundImagePath=   "resources\\buddha.png";
    private String wavFilePath="resources\\bell.wav";
    private Boolean muted;
    private int seconds=0;
    private int minutes=15;

    @Override
    public String getBackgroundImage() {
        return backgroundImagePath;
    }

    public String getWavFile(){
        return wavFilePath;
    }

    @Override
    public Boolean NotificationEnabled() {
        return false;
    }

    @Override
    public Boolean isMuted() {
        return muted;
    }

    @Override
    public Integer getPeriodSec() {
        return seconds;
    }

    @Override
    public Integer getPeriodMin() {
        return minutes;
    }

    @Override
    public void setBackgroundImage(String backgroundImage) {
        backgroundImagePath=backgroundImage;

    }

    @Override
    public void setPeriodMin(Integer periodMin) {
        minutes=periodMin;
    }

    @Override
    public void setPeriodSec(Integer periodSec) {
        periodSec=periodSec-(int)periodSec/60;

    }

    @Override
    public void Mute() {
        muted=true;
    }

    @Override
    public void Unmute() {
        muted=false;
    }

    @Override
    public void enableNotification() {

    }

    @Override
    public void disableNotification() {

    }

    @Override
    public Integer getPeriod() {
        return getPeriodMin()*60+getPeriodSec();
    }
}
