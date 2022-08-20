package com.example.servicemessanger.client;

import com.example.servicemessanger.sensorDao.SensorData;
import feign.RequestLine;

public interface SensorDataClient {
    @RequestLine("POST /messanger/v1/email" )
    void sendSensorData(SensorData sensorData);
}
