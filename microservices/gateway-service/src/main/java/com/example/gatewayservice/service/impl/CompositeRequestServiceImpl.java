package com.example.gatewayservice.service.impl;

import com.example.gatewayservice.client.AlarmServiceClient;
import com.example.gatewayservice.client.AuditClient;
import com.example.gatewayservice.dto.Sensor;
import com.example.gatewayservice.service.CompositeRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class CompositeRequestServiceImpl implements CompositeRequestService {

    private final AlarmServiceClient alarmServiceClient;
    private final AuditClient auditClient;

    @Override
    @Async
    public CompletableFuture<Long> getErrorCountAsync() {
        log.info("Get: /api/v1/sensors/count");
        Long errorCount = alarmServiceClient.getErrorCount();
        return CompletableFuture.completedFuture(errorCount);
    }

    @Override
    @Async
    public CompletableFuture<List<Sensor>> getAllWithStatusAsync(String status, Pageable page) {
        log.info("Get: /audit/v1/sensors/{}", status);
        Page<Sensor> sensors = auditClient.getAllSensorsWithStatus(status, page);
        return CompletableFuture.completedFuture(sensors.getContent());
    }
}
