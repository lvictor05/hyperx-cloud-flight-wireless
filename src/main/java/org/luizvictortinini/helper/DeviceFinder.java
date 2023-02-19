package org.luizvictortinini.helper;

import purejavahidapi.HidDeviceInfo;
import purejavahidapi.PureJavaHidApi;

import java.util.List;

public class DeviceFinder {

    public static HidDeviceInfo findHeadsetInfo() {
        List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
        for (HidDeviceInfo info : devList) {
            if (info.getProductString().contains(Constants.HEADSET_FULL_NAME)) {
                return info;
            }
        }
        return null;
    }
}
