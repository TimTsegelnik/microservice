package com.example.sensor.repository;


import com.example.sensor.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    List<Sensor> findSensorsByDateBeforeAndDateAfter(LocalDateTime before, LocalDateTime after);
}
