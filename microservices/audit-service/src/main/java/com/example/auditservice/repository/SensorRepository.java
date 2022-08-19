package com.example.auditservice.repository;


import com.example.auditservice.domein.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
