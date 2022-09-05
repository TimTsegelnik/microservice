package com.example.auditservice.service.impl;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.mapper.SensorMapper;
import com.example.auditservice.repository.SensorRepository;
import com.example.auditservice.service.SensorService;
import com.example.auditservice.service.dto.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    @Override
    public Sensor save(SensorData sensorData) {
        Sensor sensor = sensorMapper.toSensor(sensorData);
        log.info("Sensor is saving in db: {}", sensor);
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
    public Page<Sensor> findSensorsBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith) {
        return sensorRepository.findAllByDateTimeBetween(page, startWith, endWith);
    }
}