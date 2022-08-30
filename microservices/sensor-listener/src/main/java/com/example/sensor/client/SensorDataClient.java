package com.example.sensor.client;


import com.example.sensor.sensorDao.SensorMetricsDao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sensor", url = "http://sensor:8088")
public interface SensorDataClient {


    @GetMapping("/sensor/v1/data")
    SensorMetricsDao getSensorMetrics();
}
