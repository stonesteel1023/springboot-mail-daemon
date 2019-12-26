package com.demo.javamail.utils;

/*
 @Author Milan Paudyal
 @Date 5/11/19, Sat
*/

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.settings.EmailSetting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class SimpleMailSender {
    private final JavaMailSender mailSender;
    private final EmailSetting emailSetting;

    public SimpleMailSender(@Qualifier("javaMailSenderBean") JavaMailSender mailSender, EmailSetting emailSetting) {
        this.mailSender = mailSender;
        this.emailSetting = emailSetting;
    }

    /**
     * compose and send email to the given receiver
     *
     * @param emailDto containing the receiver email information and content
     */
    public void sendEmail(EmailDto emailDto) {
        MimeMessagePreparator preparator = mimeMessage -> {
            InternetAddress senderAddress = new InternetAddress(emailSetting.getSenderEmail(), emailSetting.getSenderName());
            InternetAddress receiverAddress = new InternetAddress(emailDto.getReceiverEmail(), emailDto.getReceiverName());
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