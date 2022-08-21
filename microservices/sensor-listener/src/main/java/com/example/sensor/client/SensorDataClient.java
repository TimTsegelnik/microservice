package com.example.sensor.client;


import com.example.sensor.sensorDao.SensorMetricsDao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Validated
@FeignClient(name = "sensor", url = "http://localhost:8088")
public interface SensorDataClient {

    @Valid
    @GetMapping("/sensor/v1/data")
    SensorMetricsDao getSensorMetrics();
}
