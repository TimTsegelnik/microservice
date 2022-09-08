package com.example.sensorlistener.service;


import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.dto.SensorData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorService {
    Sensor save(SensorData data);
    Iterable<Sensor>saveAll(List<SensorData> dataList);
    void sweepUpOldData(LocalDateTime dateTime);

    Page<Sensor> findSensorsBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith);

    Page<Sensor> findAll(Pageable page);
}
