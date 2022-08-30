package com.example.servicemessenger;

import com.example.allarm.domein.Sensor;

import java.time.LocalDateTime;
import java.util.List;

public final class TestSensorsData {
    public static final Sensor POPULATED_SENSOR_1 = new Sensor(1L, "qwerty@123",
            LocalDateTime.parse("2022-08-26T12:14:46.999974"),100);
    public static final Sensor POPULATED_SENSOR_2 = new Sensor(2L, "qwerty@123",
            LocalDateTime.parse("2022-08-26T12:14:46.999974"),100);
    public static final Sensor POPULATED_SENSOR_3 = new Sensor(3L, "qwerty@123",
            LocalDateTime.parse("2022-08-26T12:14:46.999974"),100);


    public static List<Sensor> getPopulatedSensors(){
        return List.of(POPULATED_SENSOR_1, POPULATED_SENSOR_2, POPULATED_SENSOR_3);
    }
}
