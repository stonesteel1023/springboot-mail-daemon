package com.demo.javamail.utils;

import com.demo.javamail.resources.EmailDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class SimpleMailSender {
    
    private final JavaMailSender mailSender;

    public SimpleMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailDto emailDto) {
        MimeMessagePreparator preparator = mimeMessage -> {
            InternetAddress senderAddress = new InternetAddress("no-reply@gmail.com", "admin");
            InternetAddress receiverAddress = new InternetAddress(emailDto.getReceiverEmail(), emailDto.getName());
            mimeMessage.setSender(senderAddress);
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(senderAddress);
            helper.setTo(receiverAddress);
            helper.setSubject(emailDto.getSubject());
            helper.setText(emailDto.getMessage());
        };
        mailSender.send(preparator);
    }
}