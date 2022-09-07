package com.example.auditservice.service;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.service.dto.SensorData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface SensorService {
    Sensor save(SensorData data);
    Page<Sensor> findByStatus(Pageable page, SensorStatus status);

    void sweepUpOldData(LocalDateTime dateTime);

    Page<Sensor> findSensorsBetween(SensorStatus status, LocalDateTime startWith, LocalDateTime endWith, Pageable page);
}
