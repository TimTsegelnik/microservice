package com.example.sensor.util;

import com.example.sensor.domain.Sensor;
import com.example.sensor.sensorDao.SensorData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public final class SensorTestData {

    public static final Sensor SENSOR_EXAMPLE_1 = new Sensor(null, "qwerty@1223", 28,
            LocalDateTime.of(2022, 6, 22, 8, 32, 44));

    public static final Sensor SENSOR_EXAMPLE_2 = new Sensor(null, "qwerty@1223", 45,
            LocalDateTime.of(2022, 4, 12, 12, 50));

    public static final Sensor SENSOR_EXAMPLE_3 = new Sensor(null, "qwerty@1223", 90,
            LocalDateTime.of(2022, 5, 7, 22, 10, 48));

    public static List<Sensor> getSensorTestExamples() {
        return List.of(SENSOR_EXAMPLE_1, SENSOR_EXAMPLE_2, SENSOR_EXAMPLE_3);
    }

    public static Page<SensorData> getSensorDataTestExample() {
        return new PageImpl<>(
                Stream.of(SENSOR_EXAMPLE_1, SENSOR_EXAMPLE_2, SENSOR_EXAMPLE_3)
                        .map(SensorData::new)
                        .toList());
    }
}
