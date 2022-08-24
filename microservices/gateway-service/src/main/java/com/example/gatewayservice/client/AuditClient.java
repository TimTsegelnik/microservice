package com.example.gatewayservice.client;

import com.example.gatewayservice.dao.SensorData;
import com.example.gatewayservice.dao.SensorStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "audit", url = "http://audit:8084")
public interface AuditClient {

    @GetMapping(value = "/audit/v1/sensors/{status}")
    Page<SensorData> getAllSensorsWithStatus(
            @PathVariable("status") SensorStatus status,
            Pageable page);
}
