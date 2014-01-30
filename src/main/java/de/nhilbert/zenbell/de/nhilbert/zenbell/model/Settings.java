package de.nhilbert.zenbell.de.nhilbert.zenbell.model;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public interface Settings {
    String getBackgroundImage();

    String getWavFile();

    Boolean NotificationEnabled();

    Boolean isMuted();

    Integer getPeriodSec();

    Integer getPeriodMin();

    void setBackgroundImage(String backgroundImage);

    void setPeriodMin(Integer periodMin);

    void setPeriodSec(Integer periodSec);

    void Mute();

    void Unmute();

    void enableNotification();

    void disableNotification();

    Integer getPeriod();
}
