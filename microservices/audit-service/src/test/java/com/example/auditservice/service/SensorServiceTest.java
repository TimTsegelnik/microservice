package com.example.auditservice.service;

import com.example.auditservice.domein.Sensor;
import com.example.auditservice.repository.SensorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.auditservice.TestSensorsExamples.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@DisplayName("Tests for SensorService")
class SensorServiceTest {

    @Autowired
    private SensorService sensorService;
    @MockBean
    private SensorRepository sensorRepository;

    @Test
    @DisplayName("Test: save Sensor with NORMAL status")
    void shouldProperlyConvertedSensorWithNormalStatus() {
        Mockito.when(sensorRepository.save(SENSOR_NORMAL)).thenReturn(SENSOR_NORMAL);

        Sensor sensor = sensorService.save(SENSOR_DATA_NORMAL);

        assertEquals(SENSOR_NORMAL, sensor);

    }

    @Test
    @DisplayName("Test: save Sensor with LOADED status")
    void shouldProperlyConvertedSensorWithLoadedStatus() {
        Mockito.when(sensorRepository.save(SENSOR_LOADED)).thenReturn(SENSOR_LOADED);

        Sensor sensor = sensorService.save(SENSOR_DATA_LOADED);

        assertEquals(SENSOR_LOADED, sensor);
    }

    @Test
    @DisplayName("Test: save Sensor with FAILED status")
    void shouldProperlyConvertedSensorWithFailedStatus() {
        Mockito.when(sensorRepository.save(SENSOR_FAILED)).thenReturn(SENSOR_FAILED);

        Sensor sensor = sensorService.save(SENSOR_DATA_FAILED);

        assertEquals(SENSOR_FAILED, sensor);
    }

    @Test
    @DisplayName("Test: throw exception if SensorData contain incorrect value")
    void shouldThrowsErrorStatus() {

        assertThrows(IllegalStateException.class, () -> sensorService.save(SENSOR_DATA_ERROR));

    }
}