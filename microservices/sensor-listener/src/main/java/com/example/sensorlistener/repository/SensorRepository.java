package com.example.sensorlistener.repository;


import com.example.sensorlistener.domein.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorRepository{
    void deleteAllByDateTimeIsBefore(LocalDateTime dateTime);

    Page<Sensor> findAllByDateTimeBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith);

    Sensor save(Sensor sensor);

    Iterable<Sensor> saveAll(List<Sensor> sensors);

    Page<Sensor> findAll(Pageable page);
}
