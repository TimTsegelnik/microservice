package com.example.auditservice.domein;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SENSOR")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;
    private LocalDateTime localDateTime;
    private Integer sensorData;
    @Enumerated(EnumType.STRING)
    private SensorStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) && Objects.equals(sensorId, sensor.sensorId) && Objects.equals(localDateTime, sensor.localDateTime) && Objects.equals(sensorData, sensor.sensorData) && status == sensor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensorId, localDateTime, sensorData, status);
    }
}


