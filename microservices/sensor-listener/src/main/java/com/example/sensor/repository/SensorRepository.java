package com.example.sensor.repository;


import com.example.sensor.domain.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {

    Page<Sensor> findSensorsByDateTimeBetween(Pageable pageable, LocalDateTime startWith, LocalDateTime endWith);
}
