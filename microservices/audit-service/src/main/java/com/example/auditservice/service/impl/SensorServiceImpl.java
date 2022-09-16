package com.example.auditservice.service.impl;

import com.example.auditservice.aspect.Loggable;
import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.mapper.SensorMapper;
import com.example.auditservice.repository.SensorRepository;
import com.example.auditservice.service.SensorService;
import com.example.auditservice.service.dto.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    @Override
    @Loggable
    public Sensor save(SensorData sensorData) {
        Sensor sensor = sensorMapper.toSensor(sensorData);
        return sensorRepository.save(sensor);
    }

    @Override
    public Page<Sensor> findByStatus(Pageable page, SensorStatus status) {
        return sensorRepository.findAllByStatusIs(page, status);
    }

    @Override
    public void sweepUpOldData(LocalDateTime dateTime) {
        sensorRepository.deleteAllByDateTimeIsBefore(dateTime);
    }

    @Override
    public Page<Sensor> findSensorsBetween(SensorStatus status, LocalDateTime startWith, LocalDateTime endWith, Pageable page) {
        return sensorRepository.findAllByStatusAndDateTimeBetween(page, status, startWith, endWith);
    }
}