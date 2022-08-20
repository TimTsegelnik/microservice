package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import feign.RequestLine;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorListenerClient {

    @RequestLine("GET /sensor-listener/v1/sensors")
    List<SensorData> getAllSensors();

    @RequestLine("GET /sensor-listener/v1/sensors/between?before={before}&after={after}")
    List<SensorData> findSensorBetween(
            @RequestParam("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime before,
            @RequestParam("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime after);
}
