package com.example.gatewayservice.dao;

import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;


public class SensorData {
    @JsonView(Views.SensorData.class)
    private String sensorId;
    @JsonView(Views.SensorData.class)
    private Integer sensorData;
    @JsonView(Views.SensorData.class)
    private LocalDateTime dateTime;
    @JsonView(Views.SensorStatus.class)
    private SensorStatus status;

    public SensorData() {
    }

    public SensorData(String sensorId, Integer sensorData, LocalDateTime dateTime) {
        this.sensorId = sensorId;
        this.sensorData = sensorData;
        this.dateTime = dateTime;
    }
    public SensorData(String sensorId, Integer sensorData, LocalDateTime dateTime, SensorStatus status) {
        this.sensorId = sensorId;
        this.sensorData = sensorData;
        this.dateTime = dateTime;
        this.status = status;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Integer getSensorData() {
        return sensorData;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public SensorStatus getStatus() {
        return status;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setSensorData(Integer sensorData) {
        this.sensorData = sensorData;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(SensorStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SensorDao{" +
                "sensorId='" + sensorId + '\'' +
                ", value=" + sensorData +
                ", dateTime=" + dateTime +
                '}';
    }
}
