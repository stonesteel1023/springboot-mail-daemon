package com.demo.javamail.service;

import com.demo.javamail.repository.MailRepository;
import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.resources.MailResult;
import com.demo.javamail.service.EmailService;
import com.demo.javamail.utils.SimpleMailSender;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService{

    private final SimpleMailSender simpleMailSender;

    @Autowired
    DataSource dataSource;

    @Autowired
    MailRepository mailRepository;

    public EmailService(SimpleMailSender simpleMailSender) {
	this.simpleMailSender = simpleMailSender;
    }

    public void excute() {
	System.out.println("======================Sending Email======================");

	List<EmailDto> list = mailRepository.findMailMessageWithStatusZero();
	
	for(EmailDto dto : list) {
	    System.out.println(dto);
	    simpleMailSender.sendEmail(dto);
	}

	System.out.println("======================	Done!	======================");
    
	for(EmailDto dto : list) {
	    System.out.println(dto);
	    MailResult result = null;
	    if(dto.getMailStatus().equals("0")) {
		result = new MailResult(dto.getId(), dto.getReceiverEmail(), "1", "send OK", new Date(), "admin");
	    }else {
		result = new MailResult(dto.getId(), dto.getReceiverEmail(), "2", "send ERROR", new Date(), "admin");
	    }
	    if(result != null) {
		mailRepository.updateMailResult(result);
	    }
	}
	
	System.out.println("================== MailResult inserted ======================");
	
	List<EmailDto> list2 = mailRepository.findMailMessageAll();
	
	for(EmailDto dto2 : list2) {
	    System.out.println(dto2);
	    if(dto2.getMailStatus().equals("0")) {
		dto2.setMailStatus("1");
	    }
	    int rs = mailRepository.updateMailStatus(dto2);
	    if(rs != 0) {
		System.out.println("update ERROR");
	    }
	}
	System.out.println("================== MailMessage updated ======================");
    }

    public void sendEmail(EmailDto emailDto) {
	simpleMailSender.sendEmail(emailDto);
    }
}