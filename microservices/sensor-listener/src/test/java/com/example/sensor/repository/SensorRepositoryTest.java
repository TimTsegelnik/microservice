package com.example.sensor.repository;

import com.example.sensor.domain.Sensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.sensor.util.SensorTestData.*;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void should_save_sensor(){
        Sensor save = sensorRepository.save(SENSOR_EXAMPLE_1);

        assertThat(save).hasFieldOrPropertyWithValue("sensorId", SENSOR_EXAMPLE_1.getSensorId());
        assertThat(save).hasFieldOrPropertyWithValue("sensorData", SENSOR_EXAMPLE_1.getSensorData());
        assertThat(save).hasFieldOrPropertyWithValue("dateTime", SENSOR_EXAMPLE_1.getDateTime());
    }

    @Test
    void should_find_data_between(){
        sensorRepository.saveAll(getSensorTestExamples());

        Page<Sensor> sensorBetween = sensorRepository.findSensorsByDateTimeBetween(
                Pageable.unpaged(),
                LocalDateTime.of(2022, 4, 12, 12, 50),
                LocalDateTime.of(2022, 5, 6, 22, 11));

        assertThat(sensorBetween.getContent())
                .contains(SENSOR_EXAMPLE_2, SENSOR_EXAMPLE_3);
    }

    @Test
    void should_find_all_data(){
        List<Sensor> sensorTestExamples = getSensorTestExamples();
        sensorRepository.saveAll(sensorTestExamples);

        Page<Sensor> all = sensorRepository.findAll(Pageable.unpaged());

        assertThat(all.getContent())
                .containsAll(sensorTestExamples);
    }

}