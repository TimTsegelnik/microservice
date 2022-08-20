package com.example.sensor.service;

import com.example.sensor.domain.Sensor;
import com.example.sensor.repository.SensorRepository;
import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.sensorDao.SensorMetricsDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<SensorData> findAllSensors() {
        return sensorRepository.findAll()
                .stream()
                .map(data -> new SensorData(
                        data.getSensorId(),
                        data.getSensorData(),
                        data.getDateTime()))
                .toList();
    }

    public List<SensorData> findAllSensorsBetween(String before, String after) {
        return sensorRepository.findSensorsByDateBeforeAndDateAfter(
                        LocalDateTime.parse(before),
                        LocalDateTime.parse(after))
                .stream()
                .map(SensorData::new)
                .toList();
    }

    public Sensor save(SensorMetricsDao sensorMetrics) {
        return sensorRepository.save(convertToSensor(sensorMetrics));
    }

    private Sensor convertToSensor(SensorMetricsDao metricsDao) {
        return new Sensor(
                null,
                metricsDao.getSensorId(),
                metricsDao.getSensorValue(),
                LocalDateTime.now()
        );
    }

}
