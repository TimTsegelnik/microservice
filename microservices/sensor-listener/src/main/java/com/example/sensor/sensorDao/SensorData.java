package com.example.sensor.sensorDao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Objects;

public class SensorData {

    private String sensorId;
    private Integer sensorData;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime localDateTime;

    public SensorData() {
    }

    public SensorData(String sensorId, Integer sensorData, LocalDateTime localDateTime) {
        this.sensorId = sensorId;
        this.sensorData = sensorData;
        this.localDateTime = localDateTime;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Integer getSensorData() {
        return sensorData;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return Objects.equals(sensorId, that.sensorId) && Objects.equals(sensorData, that.sensorData) && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, sensorData, localDateTime);
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
