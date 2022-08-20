package com.example.gatewayservice.config;

import com.example.gatewayservice.client.AuditClient;
import com.example.gatewayservice.client.MessangerServiceClient;
import com.example.gatewayservice.client.SensorListenerClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinConfig {

    @Bean
    MessangerServiceClient messangerServiceClient() {
        return Feign.builder()
                .decoder(new ResponseEntityDecoder(new JacksonDecoder()))
                .target(MessangerServiceClient.class, "http://localhost:8081");
    }

    @Bean
    SensorListenerClient sensorListenerClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(SensorListenerClient.class, "http://localhost:8087");
    }

    @Bean
    AuditClient auditClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(AuditClient.class, "http://localhost:8084");
    }

}
