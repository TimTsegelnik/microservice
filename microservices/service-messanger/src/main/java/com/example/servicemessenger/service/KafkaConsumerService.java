package com.example.servicemessenger.service;

import com.example.servicemessenger.client.SensorDataClient;
import com.example.servicemessenger.domein.Sensor;
import com.example.servicemessenger.repository.SensorRepository;
import com.example.servicemessenger.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumerService {
    private static final Integer MAX_SENSOR_VALUE = 100;
    private final SensorDataClient sensorDataClient;
    private final SensorRepository sensorRepository;

    @KafkaListener(
            topics = "sensor",
            groupId = "1"
    )
    void listener(SensorData data) {
        if (Objects.nonNull(data) &&
                Objects.equals(data.getSensorData(), MAX_SENSOR_VALUE)) {
            log.info("SensorData received from Kafka: {}", data);
            sensorRepository.save(convertToSensor(data));
            sensorDataClient.sendSensorData(data);
        }
    }

    private Sensor convertToSensor(SensorData data) {
        return new Sensor(null,
                data.getSensorId(),
                data.getDateTime(),
                data.getSensorData());
    }

}
