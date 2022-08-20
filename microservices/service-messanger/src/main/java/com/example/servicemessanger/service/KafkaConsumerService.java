package com.example.servicemessanger.service;

import com.example.servicemessanger.client.SensorDataClient;
import com.example.servicemessanger.domein.Sensor;
import com.example.servicemessanger.repository.SensorRepository;
import com.example.servicemessanger.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class KafkaConsumerService {
    private static final Integer MAX_SENSOR_VALUE = 100;
    private final SensorDataClient sensorDataClient;
    private final SensorRepository sensorRepository;

    @KafkaListener(
            topics = "sensor",
            groupId = "1",
            containerFactory = "kafkaListenerSensorFactory"
    )
    void listener(SensorData data) {
        if (Objects.nonNull(data) &&
                Objects.equals(data.getSensorData(), MAX_SENSOR_VALUE)) {
            sensorRepository.save(convertToSensor(data));
            sensorDataClient.sendSensorData(data);
        }
    }

    private Sensor convertToSensor(SensorData data) {
        return new Sensor(null,
                data.getSensorId(),
                data.getLocalDateTime(),
                data.getSensorData());
    }

}
