package com.example.sensorlistener.mapper;

import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.dto.SensorData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    Sensor toSensor(SensorData data);

    List<Sensor> toSensorsList(List<SensorData> sensorData);
}
