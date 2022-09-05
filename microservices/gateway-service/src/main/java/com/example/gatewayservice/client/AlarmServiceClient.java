package com.example.gatewayservice.client;

import com.example.gatewayservice.dto.Sensor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "alarm", url = "http://alarm:8086")
public interface AlarmServiceClient {

    @GetMapping("/alarm")
    Page<Sensor> getAll(Pageable page);

    @GetMapping("/alarm/count")
    Long getErrorCount();
}
