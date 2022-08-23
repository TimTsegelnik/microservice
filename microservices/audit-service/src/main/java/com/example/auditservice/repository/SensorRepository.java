package com.example.auditservice.repository;


import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {
    List<Sensor> findAllByStatusIs(Pageable page, SensorStatus status);
}
