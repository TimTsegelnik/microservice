package com.example.sensor.controller;

import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sensor-listener/v1/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public Page<SensorData> getAllSensors(Pageable page) {
        return sensorService.findAllSensors(page);
    }

    @GetMapping("/between")
    public Page<SensorData> findSensorsBetween(
            @RequestParam("startWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startWith,
            @RequestParam("endWith") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endWith,
            Pageable page
    ) {
        System.out.println(page + " " + startWith + " " + endWith);
        return sensorService.findAllSensorsBetween(page, startWith, endWith);
    }

}
