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
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sensor_name", nullable = false)
    private String sensorId;
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "sensor_data", nullable = false)
    private Integer sensorData;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SensorStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sensor sensor = (Sensor) o;
        return id != null && Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



