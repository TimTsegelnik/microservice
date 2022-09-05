package com.example.sensorlistener.repository;


import com.example.sensorlistener.domein.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {
    void deleteAllByDateTimeIsBefore(LocalDateTime dateTime);

    Page<Sensor> findAllByDateTimeBetween(Pageable page, LocalDateTime startWith, LocalDateTime endWith);
}
