package com.example.gatewayservice.client;

import feign.RequestLine;

public interface MessangerServiceClient {

    @RequestLine("GET /api/v1/sensors")
    Long getExceedSensorData();
}
