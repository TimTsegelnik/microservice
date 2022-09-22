package com.example.sensorlistener.domein;


import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
public class Sensor {
    private Long id;
    private String sensorId;
    private Integer sensorValue;
    private LocalDateTime dateTime;
}




