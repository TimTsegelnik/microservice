package com.example.servicemessenger.repository;

import com.example.servicemessenger.domein.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
