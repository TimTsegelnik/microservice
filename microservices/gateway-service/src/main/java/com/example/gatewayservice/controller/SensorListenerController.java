package com.example.gatewayservice.controller;

import com.example.gatewayservice.dao.SensorData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gate/v1/sensors")
public class SensorListenerController {
    @GetMapping
    public List<SensorData> getAllSensorsMetrics(){
        return null;
    }

    @GetMapping("/between")
    public List<SensorData> findSensorBetween(@RequestParam("before") String before,
                                              @RequestParam("after") String after){
        return null;
    }
}
