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
import java.util.List;


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
    public Iterable<Sensor> saveAll(List<SensorData> dataList) {
        List<Sensor> sensors = sensorMapper.toSensorsList(dataList);
        log.info("Sensor is saving in db: {}", sensors);
        return sensorRepository.saveAll(sensors);
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