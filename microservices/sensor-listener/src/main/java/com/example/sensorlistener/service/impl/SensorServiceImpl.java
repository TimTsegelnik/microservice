package com.example.sensorlistener.service.impl;


import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.mapper.SensorMapper;
import com.example.sensorlistener.repository.SensorRepository;
import com.example.sensorlistener.service.SensorService;
import com.example.sensorlistener.service.dto.SensorData;
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
        return sensorRepository.save(convertToSensor(sensorData));
    }

    private Sensor convertToSensor(SensorData data) {
        Sensor sensor = sensorMapper.toSensor(data);
        log.info("Sensor is saving in db: {}", sensor);
        return sensor;
    }


    @Override
    public void sweepUpOldData(LocalDateTime dateTime) {
        sensorRepository.deleteAllByDateTimeIsBefore(dateTime);
    }

    @Override
    public Page<Sensor> findSensorsBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith) {
        return sensorRepository.findAllByDateTimeBetween(page, startWith, endWith);
    }

    @Override
    public Page<Sensor> findAll(Pageable page) {
       return sensorRepository.findAll(page);
    }
}