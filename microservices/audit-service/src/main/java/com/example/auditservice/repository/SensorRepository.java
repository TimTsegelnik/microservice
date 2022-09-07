package com.example.auditservice.repository;


import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {
    Page<Sensor> findAllByStatusIs(Pageable page, SensorStatus status);

    void deleteAllByDateTimeIsBefore(LocalDateTime dateTime);

    Page<Sensor> findAllByStatusAndDateTimeBetween(Pageable page, SensorStatus status, LocalDateTime startWith, LocalDateTime endWith);
}
