package com.example.gatewayservice.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDateTime;


public class SensorData {
    @JsonView(Views.SensorData.class)
    private String sensorId;
    @JsonView(Views.SensorData.class)
    private Integer value;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.SensorData.class)
    private LocalDateTime dateTime;
    @JsonView(Views.SensorStatus.class)
    private SensorStatus status;

    public SensorData(String sensorId, Integer value, LocalDateTime dateTime) {
        this.sensorId = sensorId;
        this.value = value;
        this.dateTime = dateTime;
    }
    public SensorData(String sensorId, Integer value, LocalDateTime dateTime, SensorStatus status) {
        this.sensorId = sensorId;
        this.value = value;
        this.dateTime = dateTime;
        this.status = status;
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

    public SensorStatus getStatus() {
        return status;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setValue(Integer value) {
        this.value = value;
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
                ", value=" + value +
                ", dateTime=" + dateTime +
                '}';
    }
}
