package com.example.sensorlistener.mapper;

import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.dto.SensorData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    Sensor toSensor(SensorData data);
    SensorData toSensorData(Sensor sensor);
}
