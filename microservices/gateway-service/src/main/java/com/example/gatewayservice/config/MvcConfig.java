package com.example.gatewayservice.config;

import com.example.gatewayservice.GatewayServiceApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public static final String API_PREFIX = "api";

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        var packageName = GatewayServiceApplication.class.getPackageName();

        configurer.addPathPrefix(API_PREFIX,
                HandlerTypePredicate
                        .forBasePackage(packageName)
                        .and(HandlerTypePredicate.forAnnotation(RestController.class))
        );
    }
}
