package com.example.servicemessanger.service;

import com.example.servicemessanger.domein.Sensor;
import com.example.servicemessanger.repository.SensorRepository;
import com.example.servicemessanger.sensorDao.SensorData;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class KafkaListenerService {
    private static final Integer MAX_SENSOR_VALUE = 100;

    private final SensorRepository sensorRepository;
    private final EmailService emailService;

    @KafkaListener(
            topics = "sensor",
            groupId = "1",
            containerFactory = "kafkaListenerSensorFactory"
    )
    void listener(SensorData data) {
        if (Objects.equals(data.getSensorData(), MAX_SENSOR_VALUE)) {
            System.out.println(data);
            Sensor sensor = convertToSensor(data);
            sensorRepository.save(sensor);
//            emailService.send(
//                    String.format("Sensor's value exceed %d \n sensorId: %s, data: %s",
//                            MAX_SENSOR_VALUE,
//                            data.getSensorId(),
//                            data.getLocalDateTime().toString()));
        }
    }

    private Sensor convertToSensor(SensorData data) {
        return new Sensor(null,
                data.getSensorId(),
                data.getLocalDateTime(),
                data.getSensorData());
    }

}
