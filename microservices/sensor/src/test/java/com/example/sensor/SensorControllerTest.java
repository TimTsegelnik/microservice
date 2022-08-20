package com.example.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.example.sensor.SensorUtilTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnSensorDao() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/sensor/v1/data"))
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        SensorDao sensorDao = objectMapper.readValue(response, SensorDao.class);

        assertNotNull(sensorDao);
        assertEquals(SENSOR_ID, sensorDao.getSensorId());
        Integer sensorValue = sensorDao.getSensorValue();
        assertTrue(sensorValue >= MIN_ALLOWED_VALUE && sensorValue <= MAX_ALLOWED_VALUE);
    }
}