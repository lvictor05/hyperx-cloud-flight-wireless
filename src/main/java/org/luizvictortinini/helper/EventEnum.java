package org.luizvictortinini.helper;

import org.luizvictortinini.models.Event;

public enum EventEnum {
    MIC_OPEN("101 1 0", "Microphone open"),
    MIC_CLOSED("101 1 4", "Microphone muted"),
    HEADSET_ON("100 1 1", "Headset on"),
    HEADSET_OFF("100 1 3", "Headset off"),
    VOLUME_UP("1 4 1000", "Volume up"), //0x01
    HEADSET_DOWN("1 4 2000", "Volume down"), //0x02
    HEADSET_DISCONNECTED("XXXX", "Headset was disconnected"),
    NEW_EVENT("", "New Event:"),
    BATTERY_STATUS("1 4 0000", "Battery Status");


    private final String value;
    private final String message;

    EventEnum(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public static EventEnum getEventEnum(Event event) {
        for (EventEnum i : EventEnum.values()) {
            if (i.value.equals(event.getCode())) {
                return i;
            }
        }
        return EventEnum.NEW_EVENT;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
