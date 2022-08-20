package com.example.sensor.sensorDao;

import com.example.sensor.domain.Sensor;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorData {

    private String sensorId;
    private Integer sensorData;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime localDateTime;


    public SensorData(Sensor sensor) {
        this.sensorId = sensor.getSensorId();
        this.sensorData = getSensorData();
        this.localDateTime = getLocalDateTime();
    }
}
