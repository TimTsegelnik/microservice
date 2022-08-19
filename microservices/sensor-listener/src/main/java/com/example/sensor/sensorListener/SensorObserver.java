package com.example.sensor.sensorListener;

import com.example.sensor.sensorDao.SensorData;

public interface SensorObserver {
    SensorData getDataFromServer();
}
