package com.example.auditservice.aspect;

import com.example.auditservice.domein.Sensor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SensorServiceAspect {
    @AfterReturning(pointcut = "@annotation(Loggable)", returning = "sensor")
    public void logReturnValue(Sensor sensor){
        log.info("Data from SensorService before saving in db: {}", sensor);
    }
}
