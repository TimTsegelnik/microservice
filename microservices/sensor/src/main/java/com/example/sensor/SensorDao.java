package com.example.sensor;

import java.util.Objects;

public class SensorDao {
    private String sensorId;
    private Integer sensorValue;

    public SensorDao(String sensorId, Integer sensorValue) {
        this.sensorId = sensorId;
        this.sensorValue = sensorValue;
    }

    public String getSensorId() {
        return sensorId;
    }

    public Integer getSensorValue() {
        return sensorValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorDao sensorDao = (SensorDao) o;
        return Objects.equals(sensorId, sensorDao.sensorId) && Objects.equals(sensorValue, sensorDao.sensorValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, sensorValue);
    }

    @Override
    public String toString() {
        return "SensorDao{" +
                "sensorId='" + sensorId + '\'' +
                ", sensorValue=" + sensorValue +
                '}';
    }
}
