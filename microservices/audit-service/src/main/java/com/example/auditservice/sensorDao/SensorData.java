package com.example.auditservice.sensorDao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SensorData {
    private  String sensorId;
    private  Integer sensorData;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private  LocalDateTime localDateTime;
}

