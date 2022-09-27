package com.example.sensorlistener.mapper;

import com.example.sensorlistener.domein.Sensor;
import com.example.sensorlistener.service.dto.SensorData;
import com.example.sensorlistener.tables.records.SensorsRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    Sensor fromSensorData(SensorData data);

    List<Sensor> fromSensorDataToList(List<SensorData> sensorData);

    @Mapping(target = "sensorId", source = "sensorName")
    @Mapping(target = "dateTime", source = "timestamp")
    Sensor fromSensorRecord(SensorsRecord sensorsRecord);

    @Mapping(target = "sensorName", source = "sensorId")
    @Mapping(target = "timestamp", source = "dateTime")
    SensorsRecord toSensorRecord(Sensor sensor);

    List<SensorsRecord> toSensorRecordList(List<Sensor> sensors);

    List<Sensor> fromSensorRecordsToList(List<SensorsRecord> records);
}
