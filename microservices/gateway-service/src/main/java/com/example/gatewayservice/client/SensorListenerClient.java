package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface SensorListenerClient {

    @RequestLine("GET /sensor-listener/v1/sensors")
    List<SensorData> getAllSensors();

    //todo: write
    @RequestLine("GET /sensor-listener/v1/sensors/between")
    List<SensorData> findSensorBetween(@Param);
}
