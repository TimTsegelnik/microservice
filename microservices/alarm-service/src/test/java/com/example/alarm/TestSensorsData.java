package com.example.alarm;

import com.example.alarm.domein.Sensor;

import java.time.LocalDateTime;
import java.util.List;

public final class TestSensorsData {
    public static final Sensor POPULATED_SENSOR_1;
    public static final Sensor POPULATED_SENSOR_2;
    public static final Sensor POPULATED_SENSOR_3;
    static {
        POPULATED_SENSOR_1 = new Sensor();
        POPULATED_SENSOR_1.setSensorId("qwerty@1223");
        POPULATED_SENSOR_1.setSensorValue(100);
        POPULATED_SENSOR_1.setDateTime(LocalDateTime.parse("2022-08-26T12:14:46.999974"));


        POPULATED_SENSOR_2 = new Sensor();
        POPULATED_SENSOR_2.setSensorId("qwerty@1223");
        POPULATED_SENSOR_2.setSensorValue(100);
        POPULATED_SENSOR_2.setDateTime(LocalDateTime.parse("2022-08-26T12:14:46.999974"));


        POPULATED_SENSOR_3 = new Sensor();
        POPULATED_SENSOR_3.setSensorId("qwerty@1223");
        POPULATED_SENSOR_3.setSensorValue(100);
        POPULATED_SENSOR_3.setDateTime(LocalDateTime.parse("2022-08-26T12:14:46.999974"));

    }

    public static List<Sensor> getPopulatedSensors(){
        return List.of(POPULATED_SENSOR_1, POPULATED_SENSOR_2, POPULATED_SENSOR_3);
    }
}
