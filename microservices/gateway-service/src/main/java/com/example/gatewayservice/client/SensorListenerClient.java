package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sensor-listener", url = "http://sensor-listener:8087")
public interface SensorListenerClient {

    @GetMapping("/sensor-listener/v1/sensors")
    Page<SensorData> getAllSensors(Pageable pageable);

    @GetMapping("/sensor-listener/v1/sensors/between")
    Page<SensorData> findSensorBetween(
            @RequestParam("startWith") String startWith,
            @RequestParam("endWith") String endWith,
            Pageable page);
}
