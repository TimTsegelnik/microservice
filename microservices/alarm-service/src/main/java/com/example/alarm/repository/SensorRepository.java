package com.example.alarm.repository;

import com.example.alarm.domein.Sensor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {
}
