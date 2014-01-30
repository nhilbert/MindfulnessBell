package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class SampleSettingsImpl implements Settings{
    @Override
    public String getBackgroundImage() {
        return "resources\\buddha.png";
    }

    public String getWavFile(){
        return "resources\\bell.wav";
    }

    @Override
    public Boolean NotificationEnabled() {
        return false;
    }

    @Override
    public Boolean isMuted() {
        return false;
    }

    @Override
    public Integer getPeriodSec() {
        return 10;
    }

    @Override
    public Integer getPeriodMin() {
        return 0;
    }

    @Override
    public void setBackgroundImage(String backgroundImage) {

    }

    @Override
    public void setPeriodMin(Integer periodMin) {

    }

    @Override
    public void setPeriodSec(Integer periodSec) {

    }

    @Override
    public void Mute() {

    }

    @Override
    public void Unmute() {

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
