package com.example.auditservice;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.sensorDao.SensorData;

import java.time.LocalDateTime;

import static com.example.auditservice.domein.SensorStatus.*;

public class TestSensors {
    public static final Sensor SENSOR_NORMAL = new Sensor(null, "qwerty@1223",
            LocalDateTime.of(2022, 6, 22, 8, 32, 44), 28, NORMAL);

    public static final Sensor SENSOR_LOADED = new Sensor(null, "qwerty@1223",
            LocalDateTime.of(2022, 4, 12, 12, 50), 45, LOADED);

    public static final Sensor SENSOR_FAILED = new Sensor(null, "qwerty@1223",
            LocalDateTime.of(2022, 5, 7, 22, 10, 48), 90, FAILED);


    public static final SensorData SENSOR_DATA_NORMAL = new SensorData("qwerty@1223", 28,
            LocalDateTime.of(2022, 6, 22, 8, 32, 44));

    public static final SensorData SENSOR_DATA_LOADED = new SensorData("qwerty@1223", 45,
            LocalDateTime.of(2022, 4, 12, 12, 50));

    public static final SensorData SENSOR_DATA_FAILED = new SensorData("qwerty@1223", 90,
            LocalDateTime.of(2022, 5, 7, 22, 10, 48));

    public static final SensorData SENSOR_DATA_ERROR =new SensorData("qwerty@1223", 10_000,
            LocalDateTime.of(2022, 5, 7, 22, 10, 48));
}
