package com.example.sensor.service;

import com.example.sensor.client.SensorDataClient;
import com.example.sensor.domain.Sensor;
import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.sensorDao.SensorMetricsDao;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorDataListener {
    private final SensorDataClient sensorDataClient;
    private final SensorService sensorService;
    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    //todo: refactoring
    @Scheduled(fixedRate = 1000)
    void generateSensorValue() {
        SensorMetricsDao sensorMetrics = sensorDataClient.getSensorMetrics();
        System.out.println(sensorMetrics);
        Sensor sensor = sensorService.save(sensorMetrics);
        kafkaTemplate.send("sensor", new SensorData(sensor));
    }
}
