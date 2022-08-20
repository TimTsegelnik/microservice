package com.example.sensor.domain;

import com.example.sensor.sensorDao.SensorData;
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
@Table(name = "sensor_metrics")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "sensor_name", nullable = false)
    private String sensorId;
    @Column(name = "sensor_data", nullable = false)
    private Integer sensorData;
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime dateTime;

    public Sensor(SensorData sensorData) {
        this.sensorId = sensorData.getSensorId();
        this.sensorData = sensorData.getSensorData();
        this.dateTime = sensorData.getLocalDateTime();
    }

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
