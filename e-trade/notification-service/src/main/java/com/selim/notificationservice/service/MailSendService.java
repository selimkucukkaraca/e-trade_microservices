package com.selim.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailSendService {

    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String title, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("e-trade");
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(body);
        javaMailSender.send(mailMessage);
    }
}
