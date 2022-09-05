package com.example.gatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CompositeSensorResponse {
    private List<Sensor> sensors;
    private Long  currentErrorCount;
}
