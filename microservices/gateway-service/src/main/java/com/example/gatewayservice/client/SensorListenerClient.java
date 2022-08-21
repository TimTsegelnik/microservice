package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface SensorListenerClient {

    @RequestLine("GET /sensor-listener/v1/sensors")
    List<SensorData> getAllSensors();

    @RequestLine("GET /sensor-listener/v1/sensors/between?before={before}&after={after}")
    List<SensorData> findSensorBetween(
            @Param("before") String before,
            @Param("after") String after);
}
