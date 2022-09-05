package com.example.alarm.service.impl;

import com.example.alarm.service.EmailService;
import com.example.alarm.service.dto.SensorData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService<SensorData> {

    private final JavaMailSender mailSender;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
    @Value("${custom.email.from}")
    private  String from;
    @Value("${custom.email.to}")
    private  String to;


    @Override
    public void send(SensorData data) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("Sensor data error");
            helper.setText(String.format("Sensor's value exceed %d \n sensorId: %s, date: %s",
                    data.getSensorData(),
                    data.getSensorId(),
                    data.getDateTime().format(formatter)));


            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Problem attaching file to email", e);
        }
    }
}
