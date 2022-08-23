package com.example.auditservice.domein;


import lombok.*;

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
    @Column(name = "SENSOR_ID", nullable = false)
    private String sensorId;
    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "SENSOR_DATA", nullable = false)
    private Integer sensorData;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private SensorStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) && Objects.equals(sensorId, sensor.sensorId) && Objects.equals(dateTime, sensor.dateTime) && Objects.equals(sensorData, sensor.sensorData) && status == sensor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensorId, dateTime, sensorData, status);
    }
}




