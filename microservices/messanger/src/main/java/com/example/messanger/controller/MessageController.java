package com.example.messanger.controller;

import com.example.messanger.dao.SensorData;
import com.example.messanger.email.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messenger/v1/email")
public class MessageController {

    private final EmailService emailService;

    public MessageController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void emailMessage(@RequestBody SensorData sensorData){
        emailService.send(sensorData);
    }
}
