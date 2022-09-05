package com.example.auditservice.mapper;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.service.dto.SensorData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static com.example.auditservice.domein.SensorStatus.*;
import static com.example.auditservice.domein.SensorStatus.FAILED;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    SensorData toSensorData(Sensor sensor);

    @Mapping(source = "sensorData", target = "status", qualifiedByName = "getSensorStatus")
    Sensor toSensor(SensorData data);

    @Named("getSensorStatus")
    static SensorStatus getStatus(Integer sensorValue) {
        if (sensorValue <= NORMAL.getMaxValue() && sensorValue >= 0) {
            return NORMAL;
        } else if (sensorValue <= LOADED.getMaxValue() && sensorValue > NORMAL.getMaxValue()) {
            return LOADED;
        } else if (sensorValue <= FAILED.getMaxValue() && sensorValue > LOADED.getMaxValue()) {
            return FAILED;
        } else {
            throw new IllegalStateException("Sensor value cannot exceed 100 or be below 0, current value: " + sensorValue);
        }
    }
}
