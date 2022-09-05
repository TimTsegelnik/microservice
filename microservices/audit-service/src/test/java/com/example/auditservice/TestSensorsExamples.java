package com.example.auditservice;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.domein.SensorStatus;
import com.example.auditservice.service.dto.SensorData;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static com.example.auditservice.domein.SensorStatus.*;

public final class TestSensorsExamples {

    public static final Sensor SENSOR_NORMAL;
    public static final Sensor SENSOR_LOADED;
    public static Sensor SENSOR_FAILED;

    static {
        SENSOR_NORMAL = new Sensor();
        SENSOR_NORMAL.setSensorId("qwerty@1223");
        SENSOR_NORMAL.setSensorData(28);
        SENSOR_NORMAL.setDateTime(LocalDateTime.of(2022, 6, 22, 8, 32, 44));
        SENSOR_NORMAL.setStatus(NORMAL);

        SENSOR_LOADED = new Sensor();
        SENSOR_LOADED.setSensorId("qwerty@1223");
        SENSOR_LOADED.setSensorData(45);
        SENSOR_LOADED.setDateTime(LocalDateTime.of(2022, 4, 12, 12, 50));
        SENSOR_LOADED.setStatus(LOADED);

        SENSOR_FAILED = new Sensor();
        SENSOR_FAILED.setSensorId("qwerty@1223");
        SENSOR_FAILED.setSensorData(90);
        SENSOR_FAILED.setDateTime(LocalDateTime.of(2022, 5,7,22,10,48));
        SENSOR_FAILED.setStatus(FAILED);
    }

    public static final SensorData SENSOR_DATA_NORMAL = new SensorData("qwerty@1223", 28,
            LocalDateTime.of(2022, 6, 22, 8, 32, 44));

    public static final SensorData SENSOR_DATA_LOADED = new SensorData("qwerty@1223", 45,
            LocalDateTime.of(2022, 4, 12, 12, 50));

    public static final SensorData SENSOR_DATA_FAILED = new SensorData("qwerty@1223", 90,
            LocalDateTime.of(2022, 5, 7, 22, 10, 48));

    public static final SensorData SENSOR_DATA_ERROR = new SensorData("qwerty@1223", 10_000,
            LocalDateTime.of(2022, 5, 7, 22, 10, 48));

    public static Sensor getSensorExampleWithStatus(SensorStatus status) {
        return Stream.of(SENSOR_NORMAL, SENSOR_LOADED, SENSOR_FAILED)
                .filter(sensor -> sensor.getStatus().equals(status))
                .findFirst().get();
    }
}
