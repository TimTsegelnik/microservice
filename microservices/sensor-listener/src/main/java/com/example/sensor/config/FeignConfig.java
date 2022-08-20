package com.example.sensor.config;

import com.example.sensor.client.SensorDataClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    SensorDataClient sensorDataClient(){
        return Feign.builder()
                .decoder(new ResponseEntityDecoder(new JacksonDecoder()))
                .target(SensorDataClient.class, "http://localhost:8088");
    }
}
