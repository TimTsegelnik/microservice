package com.example.alarm.mapper;


import com.example.alarm.domein.Sensor;
import com.example.alarm.service.dto.SensorData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    Sensor toSensor(SensorData data);
    SensorData toSensorData(Sensor sensor);
}
