package com.example.alarm.controller;

import com.example.alarm.domein.Sensor;
import com.example.alarm.service.SensorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alarm")
@AllArgsConstructor
@Slf4j
public class SensorController {

    private final SensorService sensorService;


    @GetMapping
    Page<Sensor> getAllErrSensor(Pageable page) {
        log.info("SensorController Get: api/v1/sensors with Pageable: {}", page);
        return sensorService.findAll(page);
    }

    @GetMapping("/count")
    public Long getCountOfExceedSensorValue() {
        log.info("SensorController Get: api/v1/sensors/count");
        return sensorService.count();
    }

}
