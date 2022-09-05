package com.example.alarm.service.impl;

import com.example.alarm.domein.Sensor;
import com.example.alarm.mapper.SensorMapper;
import com.example.alarm.service.BrokerConsumerService;
import com.example.alarm.service.SensorService;
import com.example.alarm.service.dto.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class BrokerConsumerServiceImpl implements BrokerConsumerService {
    private static final Integer MAX_SENSOR_VALUE = 100;
    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @KafkaListener(
            topics = "sensor",
            groupId = "1"
    )
    @Override
    public void listen(SensorData data) {
        if (Objects.nonNull(data) &&
                Objects.equals(data.getSensorData(), MAX_SENSOR_VALUE)) {
            log.info("SensorData received from Kafka: {}", data);
            Sensor sensor = sensorMapper.toSensor(data);
            sensorService.save(sensor);
        }
    }

}
