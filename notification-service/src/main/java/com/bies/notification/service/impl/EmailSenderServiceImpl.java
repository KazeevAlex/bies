package com.bies.notification.service.impl;

import com.bies.notification.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    @Value("${spring.mail.username}")
    public static String FROM_EMAIL_ADDRESS;

    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(FROM_EMAIL_ADDRESS);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        this.javaMailSender.send(mailMessage);
    }
}
