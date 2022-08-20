package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.SensorStatus;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuditClient {

    @RequestLine("GET /audit/v1/sensors/{status}")
    List<SensorData> getAllSensorsWithStatus(@PathVariable("status") SensorStatus status);
}
