package com.example.gatewayservice.client;

import com.example.gatewayservice.dto.Sensor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sensor-listener", url = "http://sensor-listener:8086")
public interface SensorListenerClient {
    @GetMapping(value = "/sensor-listener")
    Page<Sensor> getAllSensors(Pageable page);

    @GetMapping(value = "/sensor-listener/between")
    Page<Sensor> getAllSensorsBetween(
            @RequestParam("startWith") String startWith,
            @RequestParam("endWith") String endWith,
            Pageable page
    );
}
