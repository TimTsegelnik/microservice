package com.example.alarm.service.impl;

import com.example.alarm.domein.Sensor;
import com.example.alarm.repository.SensorRepository;
import com.example.alarm.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public Page<Sensor> findAll(Pageable page) {
        return sensorRepository.findAll(page);
    }

    @Override
    public Long count() {
        return sensorRepository.count();
    }

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

}
