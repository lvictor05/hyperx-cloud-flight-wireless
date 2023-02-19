package org.luizvictortinini.models;

public class Event {

    private String code;

    public Event(byte id, byte[] data, int len) {
        String dataS = id + " " + len + " ";
        for (int i = 0; i < len; i++) {
            dataS = dataS.concat(String.valueOf(data[i]));
        }
        code = dataS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Event{" +
                "code='" + code + '\'' +
                '}';
    }
}
