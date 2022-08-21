package com.example.sensor.sensorDao;

import com.example.sensor.domain.Sensor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SensorData {

    private String sensorId;
    private Integer sensorData;
    private LocalDateTime dateTime;


    public SensorData(Sensor sensor) {
        this.sensorId = sensor.getSensorId();
        this.sensorData = sensor.getSensorData();
        this.dateTime = sensor.getDateTime();
    }
}
