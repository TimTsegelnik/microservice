package com.example.messanger.dao;

import java.time.LocalDateTime;


public class SensorData {
    private  String sensorId;
    private  Integer sensorData;
    private  LocalDateTime localDateTime;

    public SensorData(String sensorId, Integer sensorData, LocalDateTime localDateTime) {
        this.sensorId = sensorId;
        this.sensorData = sensorData;
        this.localDateTime = localDateTime;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getSensorData() {
        return sensorData;
    }

    public void setSensorData(Integer sensorData) {
        this.sensorData = sensorData;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sensorId='" + sensorId + '\'' +
                ", sensorData=" + sensorData +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

