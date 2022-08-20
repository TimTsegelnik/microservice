package com.example.sensor.controller;

import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor-listener/v1/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public List<SensorData> getAllSensors() {
        return sensorService.findAllSensors();
    }

    @GetMapping("/between")
    public List<SensorData> findSensorsBetween(@RequestParam("before") String before,
                                           @RequestParam("after") String after) {
        return sensorService.findAllSensorsBetween(before, after);
    }

}
