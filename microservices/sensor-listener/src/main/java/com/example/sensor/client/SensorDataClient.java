package com.example.sensor.client;


import com.example.sensor.sensorDao.SensorMetricsDao;
import feign.RequestLine;

public interface SensorDataClient {

    @RequestLine("GET /api/v1/sensor")
    SensorMetricsDao getSensorMetrics();
}
