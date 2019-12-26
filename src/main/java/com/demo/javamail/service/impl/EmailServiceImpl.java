package com.demo.javamail.service.impl;

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.service.EmailService;
import com.demo.javamail.utils.SimpleMailSender;
import org.springframework.stereotype.Service;

/*
 @Author Milan Paudyal
 @Date 5/12/19, Sun
*/

@Service
public class EmailServiceImpl implements EmailService {

    private final SimpleMailSender simpleMailSender;

    public EmailServiceImpl(SimpleMailSender simpleMailSender) {
        this.simpleMailSender = simpleMailSender;
    }

    @Override
    public void sendEmail(EmailDto emailDto) {
        simpleMailSender.sendEmail(emailDto);
    }
}