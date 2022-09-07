package com.example.gatewayservice.client;

import com.example.gatewayservice.dto.Sensor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "audit", url = "http://audit:8084")
public interface AuditClient {
    @GetMapping(value = "/audit/{status}")
    Page<Sensor> getAllSensorsWithStatus(
            @PathVariable("status") String status,
            Pageable page);

    @GetMapping(value = "/audit/between/{status}")
    Page<Sensor> findSensorBetween(
            @PathVariable("status") String status,
            @RequestParam("startWith") String startWith,
            @RequestParam("endWith") String endWith,
            Pageable page);
}
