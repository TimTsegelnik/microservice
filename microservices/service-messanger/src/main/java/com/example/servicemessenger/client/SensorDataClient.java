package com.example.servicemessenger.client;

import com.example.servicemessenger.sensorDao.SensorData;
import feign.RequestLine;

public interface SensorDataClient {
    @RequestLine("POST /messenger/v1/email" )
    void sendSensorData(SensorData sensorData);
}
