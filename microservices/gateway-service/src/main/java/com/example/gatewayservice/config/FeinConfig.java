package com.example.gatewayservice.config;

import com.example.gatewayservice.client.AuditClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinConfig {

    @Bean
    AuditClient auditClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(AuditClient.class, "http://localhost:8084");
    }

}
