package com.demo.javamail.service;

import com.demo.javamail.resources.EmailDto;

/*
 @Author Milan Paudyal
 @Date 5/12/19, Sun
*/
public interface EmailService {
    void sendEmail(EmailDto emailDto);
}
