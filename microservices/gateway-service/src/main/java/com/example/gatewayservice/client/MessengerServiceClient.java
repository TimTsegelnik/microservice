package com.example.gatewayservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "messenger", url = "http://localhost:8086")
public interface MessengerServiceClient {
    @GetMapping("/api/v1/sensors")
    Long getExceedSensorData();
}
