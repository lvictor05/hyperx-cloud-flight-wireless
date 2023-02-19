package org.luizvictortinini.models;

public class HeadsetStatus {

    private boolean headsetConnected;
    private boolean headsetOn;
    private boolean microphoneOpen;
    private int battery;
    private boolean showMessages;

    public boolean isShowMessages() {
        return showMessages;
    }

    public void setShowMessages(boolean showMessages) {
        this.showMessages = showMessages;
    }

    public boolean isMicrophoneOpen() {
        return microphoneOpen;
    }

    public void setMicrophoneOpen(boolean microphoneOpen) {
        this.microphoneOpen = microphoneOpen;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public boolean isHeadsetOn() {
        return headsetOn;
    }

    public void setHeadsetOn(boolean headsetOn) {
        this.headsetOn = headsetOn;
    }

    public boolean isHeadsetConnected() {
        return headsetConnected;
    }

    public void setHeadsetConnected(boolean headsetConnected) {
        this.headsetConnected = headsetConnected;
    }
}
