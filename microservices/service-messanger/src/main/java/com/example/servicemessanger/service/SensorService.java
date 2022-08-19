package com.example.servicemessanger.service;

import com.example.servicemessanger.repository.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public Long countExceedValue() {
        return sensorRepository.count();
    }
}
