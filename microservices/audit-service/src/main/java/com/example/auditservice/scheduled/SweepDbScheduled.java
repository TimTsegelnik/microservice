package com.example.auditservice.scheduled;

import com.example.auditservice.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class SweepDbScheduled {

    private final SensorService sensorService;

    @Scheduled(cron = "@weekly")
    void sweepUp() {
        LocalDateTime minusMonths = LocalDateTime.now().minusWeeks(1);
        sensorService.sweepUpOldData(minusMonths);
    }
}
