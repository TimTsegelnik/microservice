package com.example.sensorlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorListenerApplication.class, args);
    }

}
