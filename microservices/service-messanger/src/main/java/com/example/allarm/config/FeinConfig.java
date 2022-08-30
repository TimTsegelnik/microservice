package com.example.allarm.config;

import com.example.allarm.client.SensorDataClient;
import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinConfig {

    @Bean
    SensorDataClient messengerServiceClient() {
        return Feign.builder()
                .target(SensorDataClient.class, "http://messenger:8085");
    }
}
