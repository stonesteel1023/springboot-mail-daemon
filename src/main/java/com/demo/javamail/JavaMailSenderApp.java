package com.demo.javamail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;

import com.demo.javamail.service.EmailService;


@SpringBootApplication
public class JavaMailSenderApp implements CommandLineRunner {

    @Autowired
    private EmailService service;

    public static void main(String[] args) {
	SpringApplication.run(JavaMailSenderApp.class);
    }

    @Override
    public void run(String... args) {

	service.excute();
    }

//    @Autowired
//    private MailSender  mailSender;
    
    //  System.out.println("Sending Email...");
    
    //  SimpleMailMessage msg = new SimpleMailMessage();
    //  msg.setTo("test1@gmail.com", "test2@yahoo.com");
    //  msg.setSubject("Testing from Spring Boot");
    //  msg.setText("Hello World \n Spring Boot Email");
    //
    //  mailSender.send(msg);
}