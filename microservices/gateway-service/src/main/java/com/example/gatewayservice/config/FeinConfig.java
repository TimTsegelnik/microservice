package com.example.gatewayservice.config;

import com.example.gatewayservice.client.MessangerServiceClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeinConfig {

    @Bean
    MessangerServiceClient messangerServiceClient(){
        return Feign.builder()
                .decoder(new ResponseEntityDecoder(new JacksonDecoder()))
                .target(MessangerServiceClient.class, "http://localhost:8081");
    }


}
