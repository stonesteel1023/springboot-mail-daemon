package com.demo.javamail.service.impl;

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.service.EmailService;
import com.demo.javamail.utils.SimpleMailSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;

/*
 @Author Milan Paudyal
 @Date 5/12/19, Sun
*/

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceImplTest {

    @Mock
    private SimpleMailSender simpleMailSender;

    private EmailService emailService;

    private EmailDto emailDto;

    @Before
    public void setUp() {
        emailService = new EmailServiceImpl(simpleMailSender);
        emailDto = new EmailDto();
        emailDto.setReceiverEmail("stonesteel84@gmail.com");
        emailDto.setReceiverName("Test tst");
        emailDto.setSubject("test");
        emailDto.setMessage("Hello test");
        Mockito.doNothing().when(simpleMailSender).sendEmail(emailDto);
        Mockito.doThrow(RuntimeException.class).when(simpleMailSender).sendEmail(null);
    }

    @Test(expected = Exception.class)
    public void testSendEmail_when_InvalidEmailDto() {
        emailDto = null;
        emailService.sendEmail(emailDto);
    }

    @Test
    public void testSendEmail_when_validEmailDto() {
        emailService.sendEmail(emailDto);
        Mockito.verify(simpleMailSender, times(1))
                .sendEmail(emailDto);
    }
}