package com.example.sensorlistener.service;


import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.dto.SensorData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface SensorService {
    Sensor save(SensorData data);

    void sweepUpOldData(LocalDateTime dateTime);

    Page<Sensor> findSensorsBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith);

    Page<Sensor> findAll(Pageable page);
}
