package com.example.messanger.email;

import com.example.messanger.dao.SensorData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
    private final String from;
    private final String to;

    public EmailServiceImpl(JavaMailSender mailSender,
                            @Value("${custom.email.from}") String from,
                            @Value("${custom.email.to}") String to) {
        this.mailSender = mailSender;
        this.from = from;
        this.to = to;
    }

    //todo: maybe should use queue to resend email?
    @Override
    @Async
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
                    data.getLocalDateTime().format(formatter)));

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Problem attaching file to email", e);
        }
    }
}
