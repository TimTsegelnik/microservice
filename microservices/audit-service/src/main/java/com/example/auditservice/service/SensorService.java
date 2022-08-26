package com.example.auditservice.service;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.repository.SensorRepository;
import com.example.auditservice.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.auditservice.domein.SensorStatus.*;

@Service
@AllArgsConstructor
@Slf4j
public class SensorService {
    private final SensorRepository sensorRepository;

    public Sensor save(SensorData sensorData) {
        return sensorRepository.save(convertToSensor(sensorData));
    }

    private Sensor convertToSensor(SensorData data) {
        Integer sensorData = data.getSensorData();

        Sensor sensor = new Sensor(null, data.getSensorId(), data.getDateTime(), data.getSensorData(), null);

        if (sensorData <= NORMAL.getMaxValue() && sensorData >= 0) {
            sensor.setStatus(NORMAL);
        } else if (sensorData <= LOADED.getMaxValue() && sensorData > NORMAL.getMaxValue()) {
            sensor.setStatus(LOADED);
        } else if (sensorData <= FAILED.getMaxValue() && sensorData > LOADED.getMaxValue()) {
            sensor.setStatus(FAILED);
        } else if (sensorData > FAILED.getMaxValue()) {
            log.error("Sensor data have incorrect value = {}", sensorData);
            throw new IllegalStateException("Sensor value cannot exceed 100 or be below 0, current value: " + sensorData);
        }
        log.info("Sensor is saving in db: {}", sensor);
        return sensor;
    }

    public Page<Sensor> getAllSensorWithStatus(Pageable page, SensorStatus status) {
        return sensorRepository.findAllByStatusIs(page, status);
    }
}