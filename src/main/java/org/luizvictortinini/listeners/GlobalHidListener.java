package org.luizvictortinini.listeners;

import org.luizvictortinini.helper.EventEnum;
import org.luizvictortinini.models.Event;
import org.luizvictortinini.models.HeadsetStatus;
import org.luizvictortinini.services.UiService;
import purejavahidapi.DeviceRemovalListener;
import purejavahidapi.HidDevice;
import purejavahidapi.InputReportListener;

public class GlobalHidListener implements InputReportListener, DeviceRemovalListener {

    private final HeadsetStatus headsetStatus = new HeadsetStatus();
    private final UiService uiService = new UiService(headsetStatus);

    @Override
    public void onDeviceRemoval(HidDevice hidDevice) {
        headsetStatus.setHeadsetConnected(false);
        uiService.showMessage(EventEnum.HEADSET_DISCONNECTED.getMessage(), true);
        uiService.loadScreenValues();
    }

    @Override
    public void onInputReport(HidDevice hidDevice, byte b, byte[] bytes, int i) {
        Event event = new Event(b, bytes, i);
        setHeadsetConnectedAndOn(event);
        EventEnum eventEnum = EventEnum.getEventEnum(event);
        switch (eventEnum) {
            case HEADSET_ON -> headsetOn();
            case HEADSET_OFF -> headsetOff();
            case MIC_OPEN -> micOpen();
            case MIC_CLOSED -> micClosed();
        }
    }

    private void setHeadsetConnectedAndOn(Event event) {
        if (!EventEnum.HEADSET_OFF.getValue().equals(event.getCode())) {
            headsetStatus.setHeadsetConnected(true);
            headsetStatus.setHeadsetOn(true);
        }
    }

    private void micOpen() {
        headsetStatus.setMicrophoneOpen(true);
        uiService.showMessage(EventEnum.MIC_OPEN.getMessage());
    }

    private void micClosed() {
        headsetStatus.setMicrophoneOpen(false);
        uiService.showMessage(EventEnum.MIC_CLOSED.getMessage());
    }

    private void headsetOn() {
        headsetStatus.setHeadsetOn(true);
        uiService.showMessage(EventEnum.HEADSET_ON.getMessage());
    }

    private void headsetOff() {
        headsetStatus.setHeadsetOn(false);
        uiService.showMessage(EventEnum.HEADSET_OFF.getMessage());
    }


}
