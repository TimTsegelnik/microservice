package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@FeignClient(name = "sensor-listener", url = "http://sensor-listener:8087")
public interface SensorListenerClient {

    @GetMapping("/sensor-listener/v1/sensors")
    Page<SensorData> getAllSensors(Pageable pageable);

    @GetMapping("/sensor-listener/v1/sensors/between")
    Page<SensorData> findSensorBetween(
            Pageable page,
            @RequestParam("startWith") LocalDateTime startWith,
            @RequestParam("endWith") LocalDateTime endWith);
}
