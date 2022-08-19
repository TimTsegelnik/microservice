package com.example.servicemessanger.repository;

import com.example.servicemessanger.domein.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
