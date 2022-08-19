package com.example.servicemessanger.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;


    private final String emailFrom  = "shadow.wariorx007@gmail.com";
    private final String emailTo = "zlaypanda@mail.ru";

    //  maybe should use queue to resend email?
    @Override
    @Async
    public void send(String email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setFrom(emailFrom);
            helper.setTo(emailTo);
            helper.setSubject("Sensor data error");
            helper.setText(email);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Problem attaching file to email", e);
        }
    }
}
