package com.example.servicemessenger.repository;

import com.example.allarm.domein.Sensor;
import com.example.allarm.repository.SensorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.example.servicemessenger.TestSensorsData.POPULATED_SENSOR_1;
import static com.example.servicemessenger.TestSensorsData.getPopulatedSensors;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;


    @Test
    void should_save_new_sensor() {
        Sensor save = sensorRepository.save(POPULATED_SENSOR_1);

        assertThat(save).hasFieldOrPropertyWithValue("sensorId", POPULATED_SENSOR_1.getSensorId());
        assertThat(save).hasFieldOrPropertyWithValue("sensorData", POPULATED_SENSOR_1.getSensorData());
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