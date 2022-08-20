package com.example.servicemessanger.config;

import com.example.servicemessanger.client.SensorDataClient;
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
