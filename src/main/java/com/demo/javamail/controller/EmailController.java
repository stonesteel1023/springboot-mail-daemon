package com.demo.javamail.controller;

/*
 @Author Milan Paudyal
 @Date 5/11/19, Sat
*/

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.service.EmailService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public void sendEmail() {
	EmailDto emailDto = new EmailDto();
	emailDto.setReceiverEmail("stonebstonesteel@gmail.com");
	emailDto.setReceiverName("Novice Geeker");
	emailDto.setSubject("Test email");
	emailDto.setMessage("Have a nice day!!!");
        emailService.sendEmail(emailDto);
    }
}
