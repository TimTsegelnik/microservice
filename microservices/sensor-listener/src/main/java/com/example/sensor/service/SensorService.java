package com.example.sensor.service;

import com.example.sensor.domain.Sensor;
import com.example.sensor.repository.SensorRepository;
import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.sensorDao.SensorMetricsDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public Page<SensorData> findAllSensors(Pageable page) {
        return convertToSensorData(sensorRepository.findAll(page));
    }

    public Page<SensorData> findAllSensorsBetween(
            Pageable page,
            LocalDateTime startWith,
            LocalDateTime endWith
    ) {
        Page<Sensor> sensorsByDateTimeBetween =
                sensorRepository.findSensorsByDateTimeBetween(
                        page, startWith, endWith);

        return convertToSensorData(sensorsByDateTimeBetween);
    }


    public Sensor save(SensorMetricsDao sensorMetrics) {
        return sensorRepository.save(convertToSensor(sensorMetrics));
    }

    private static Page<SensorData> convertToSensorData(Page<Sensor> sensors) {
        return sensors.map(SensorData::new);
    }

    private static Sensor convertToSensor(SensorMetricsDao metricsDao) {
        return new Sensor(
                null,
                metricsDao.getSensorId(),
                metricsDao.getSensorValue(),
                LocalDateTime.now()
        );
    }

}
