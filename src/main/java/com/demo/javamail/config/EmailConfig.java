package com.demo.javamail.config;

import com.demo.javamail.constants.EmailConstant;
import com.demo.javamail.settings.EmailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/*
 @Author Milan Paudyal
 @Date 5/11/19, Sat
*/
@Configuration
public class EmailConfig {

    private final EmailSetting emailSetting;

    @Autowired
    public EmailConfig(EmailSetting emailSetting) {
        this.emailSetting = emailSetting;
    }

    @Bean("javaMailSenderBean")
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailSetting.getHost());
        mailSender.setPassword(emailSetting.getPassword());
        mailSender.setUsername(emailSetting.getUsername());
        mailSender.setPort(emailSetting.getPort());
        mailSender.setProtocol(emailSetting.getProtocol());
        mailSender.setJavaMailProperties(getMailProperties());
        return mailSender;
    }

    private Properties getMailProperties() {
        Properties props = new Properties();
        props.put(EmailConstant.SMTP_AUTH, emailSetting.getAuth());
        props.put(EmailConstant.SMTP_STARTLS, emailSetting.getStarttlsEnable());
        return props;
    }
}

