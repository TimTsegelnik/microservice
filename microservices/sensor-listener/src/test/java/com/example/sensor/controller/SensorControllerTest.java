package com.example.sensor.controller;

import com.example.sensor.repository.SensorRepository;
import com.example.sensor.sensorDao.SensorData;
import com.example.sensor.util.SensorTestData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.example.sensor.util.SensorTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class SensorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private SensorRepository sensorRepository;


    @Test
    void shouldGetAllReturnValue() throws Exception {

        Mockito.when(sensorRepository.findAll())
                .thenReturn(getSensorTestExamples());

        MvcResult mvcResult = mockMvc.perform(get("/sensor-listener/v1/sensors"))
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        List<SensorData> sensorData = objectMapper.readValue(response, new TypeReference<List<SensorData>>() {});

        assertEquals(sensorData, getSensorDataTestExample());

    }

}