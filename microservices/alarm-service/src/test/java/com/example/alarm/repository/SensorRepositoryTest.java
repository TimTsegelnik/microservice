package com.example.alarm.repository;

import com.example.alarm.domein.Sensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.example.alarm.TestSensorsData.POPULATED_SENSOR_1;
import static com.example.alarm.TestSensorsData.getPopulatedSensors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;


    @Test
    void should_save_new_sensor() {
        Sensor save = sensorRepository.save(POPULATED_SENSOR_1);

        assertThat(save).hasFieldOrPropertyWithValue("sensorId", POPULATED_SENSOR_1.getSensorId());
        assertThat(save).hasFieldOrPropertyWithValue("sensorData", POPULATED_SENSOR_1.getSensorValue());
        assertThat(save).hasFieldOrPropertyWithValue("dateTime", POPULATED_SENSOR_1.getDateTime());

    }

    @Test
    void should_count_with_new_sensors() {
        long countBefore = sensorRepository.count();

        sensorRepository.saveAll(getPopulatedSensors());

        long countAfter = sensorRepository.count();

        assertThat(countAfter).isEqualTo(countBefore + 3);
    }
}