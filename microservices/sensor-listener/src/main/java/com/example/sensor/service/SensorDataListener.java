package com.example.sensor.service;

import com.example.sensor.client.SensorDataClient;
import com.example.sensor.domain.Sensor;
import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.sensorDao.SensorMetricsDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SensorDataListener {
    private final SensorDataClient sensorDataClient;
    private final KafkaProducerService kafkaProducerService;
    private final SensorService sensorService;




    @Async
    @Scheduled(fixedRate = 1000)
    public void getSensorData() {
        SensorMetricsDao response = sensorDataClient.getSensorMetrics();
        log.info("Received from sensor data {}", response);
        Sensor sensor = sensorService.save(response);
        kafkaProducerService.send(new SensorData(sensor));
    }

   /* @Async
    CompletableFuture<SensorMetricsDao> getSensorData(){
        SensorMetricsDao response = sensorDataClient.getSensorMetrics();
        return CompletableFuture.completedFuture(....);
    }*/
}
