package com.example.alarm.service;

import com.example.alarm.domein.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SensorService {
    Page<Sensor> findAll(Pageable page);
    Long count();
    Sensor save(Sensor sensor);

}
