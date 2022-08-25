package com.example.auditservice.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompositeSensorKey implements Serializable {
    private Long id;
    private SensorStatus status;
}
