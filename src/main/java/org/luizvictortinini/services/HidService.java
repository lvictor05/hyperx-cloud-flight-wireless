package org.luizvictortinini.services;

import org.luizvictortinini.helper.DeviceFinder;
import org.luizvictortinini.listeners.GlobalHidListener;
import purejavahidapi.HidDevice;
import purejavahidapi.PureJavaHidApi;

import java.io.IOException;


public class HidService {

    public void run() {
        final HidDevice hidDevice;
        try {
            final GlobalHidListener globalHidListener = new GlobalHidListener();
            hidDevice = PureJavaHidApi.openDevice(DeviceFinder.findHeadsetInfo());
            hidDevice.setInputReportListener(globalHidListener);
            hidDevice.setDeviceRemovalListener(globalHidListener);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}







