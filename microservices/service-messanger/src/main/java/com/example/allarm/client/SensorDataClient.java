package com.example.allarm.client;

import com.example.allarm.sensorDao.SensorData;
import feign.RequestLine;

public interface SensorDataClient {
    @RequestLine("POST /messenger/v1/email" )
    void sendSensorData(SensorData sensorData);
}
