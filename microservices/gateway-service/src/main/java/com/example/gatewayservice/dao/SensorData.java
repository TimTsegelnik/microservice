package com.example.gatewayservice.dao;

import java.time.LocalDateTime;


public class SensorData {
    private String sensorId;
    private Integer value;
    private LocalDateTime dateTime;

    public SensorData(String sensorId, Integer value, LocalDateTime dateTime) {
        this.sensorId = sensorId;
        this.value = value;
        this.dateTime = dateTime;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Integer getValue() {
        return value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "SensorDao{" +
                "sensorId='" + sensorId + '\'' +
                ", value=" + value +
                ", dateTime=" + dateTime +
                '}';
    }
}
