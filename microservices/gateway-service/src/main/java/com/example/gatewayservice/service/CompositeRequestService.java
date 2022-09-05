package com.example.gatewayservice.service;

import com.example.gatewayservice.dto.Sensor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CompositeRequestService {

    CompletableFuture<Long> getErrorCountAsync();

    CompletableFuture<List<Sensor>> getAllWithStatusAsync(String status, Pageable page);
}
