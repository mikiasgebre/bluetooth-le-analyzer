/****************************************************************************
 * This file is part of Bluetooth LE Analyzer.                              *
 * <p/>                                                                     *
 * Copyright (C) 2017  Bertrand Martel                                      *
 * <p/>                                                                     *
 * Foobar is free software: you can redistribute it and/or modify           *
 * it under the terms of the GNU General Public License as published by     *
 * the Free Software Foundation, either version 3 of the License, or        *
 * (at your option) any later version.                                      *
 * <p/>                                                                     *
 * Foobar is distributed in the hope that it will be useful,                *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of           *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            *
 * GNU General Public License for more details.                             *
 * <p/>                                                                     *
 * You should have received a copy of the GNU General Public License        *
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.          *
 */
package com.github.akinaru.bleanalyzer.bluetooth.events;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

import com.github.akinaru.bleanalyzer.constant.JsonConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Object used to wrap broadcast intent json output
 *
 * @author Bertrand Martel
 */
public class BluetoothObject {

    private String deviceAddress = "";

    private String deviceName = "";

    private int deviceRssi ;

    private int advertizingInterval = -1;

    public BluetoothObject(String deviceAddress, String deviceName, int advertizingInterval,int deviceRssi) {
        this.deviceAddress = deviceAddress;
        this.deviceName = deviceName;
        this.advertizingInterval = advertizingInterval;
        this.deviceRssi = deviceRssi;
    }

    public static BluetoothObject parseArrayList(Intent intent) {

        ArrayList<String> actionsStr = intent.getStringArrayListExtra("");

        if (actionsStr.size() > 0) {

            try {

                JSONObject mainObject = new JSONObject(actionsStr.get(0));

                if (mainObject.has(JsonConstants.BT_ADDRESS) &&
                        mainObject.has(JsonConstants.BT_DEVICE_NAME)) {

                    int scanInterval = -1;
                    if (mainObject.has(JsonConstants.BT_ADVERTISING_INTERVAL))
                        scanInterval = mainObject.getInt(JsonConstants.BT_ADVERTISING_INTERVAL);
                    Log.i("intent ", "sdf" +  mainObject.get(JsonConstants.BT_DEVICE_RSSI).toString());
                    return new BluetoothObject(mainObject.get(JsonConstants.BT_ADDRESS).toString(),
                            mainObject.get(JsonConstants.BT_DEVICE_NAME).toString(),
                            scanInterval, (Integer) mainObject.get(JsonConstants.BT_DEVICE_RSSI));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public int getDeviceRssi(){
        return deviceRssi;
    }

    public int getAdvertizingInterval() {
        return advertizingInterval;
    }

    public void setAdvertizingInterval(int advertizingInterval) {
        this.advertizingInterval = advertizingInterval;
    }
}
