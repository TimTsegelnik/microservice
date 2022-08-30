package com.example.allarm.controller;

import com.example.allarm.service.SensorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sensors")
@AllArgsConstructor
@Slf4j
public class SensorController {

    private final SensorService sensorService;

    @GetMapping("/count")
    public Long getCountOfExceedSensorValue() {
        log.info("SensorController Get: api/v1/sensors/count");
        return sensorService.countExceedValue();
    }
}
