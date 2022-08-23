package com.example.auditservice.service;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.repository.SensorRepository;
import com.example.auditservice.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.auditservice.domein.SensorStatus.*;

@Service
@AllArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;

    public Sensor save(SensorData sensorData) {
        return sensorRepository.save(convertToSensor(sensorData));
    }

    private Sensor convertToSensor(SensorData data) {
        Integer sensorData = data.getSensorData();

        Sensor sensor = new Sensor(null, data.getSensorId(), data.getDateTime(), sensorData, null);

        if (sensorData <= NORMAL.getMaxValue() && sensorData >= 0) {
            sensor.setStatus(NORMAL);
        } else if (sensorData <= LOADED.getMaxValue() && sensorData > NORMAL.getMaxValue()) {
            sensor.setStatus(LOADED);
        } else if (sensorData <= FAILED.getMaxValue() && sensorData > LOADED.getMaxValue()) {
            sensor.setStatus(FAILED);
        } else if (sensorData > FAILED.getMaxValue()) {
            throw new IllegalStateException("Sensor value cannot exceed 100 or be below 0, current value: " + sensorData);
        }
        return sensor;
    }

    public List<Sensor> getAllSensorWithStatus(Pageable page, SensorStatus status) {
        return sensorRepository.findAllByStatusIs(page, status);
    }
}