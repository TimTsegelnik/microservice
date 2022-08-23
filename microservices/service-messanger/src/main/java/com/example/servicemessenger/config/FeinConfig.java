package com.example.servicemessenger.config;

import com.example.servicemessenger.client.SensorDataClient;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinConfig {

    @Bean
    SensorDataClient messangerServiceClient() {
        return Feign.builder()
                .target(SensorDataClient.class, "http://localhost:8085");
    }
}
