package com.demo.javamail.utils;

import com.demo.javamail.resources.EmailDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;



@RunWith(MockitoJUnitRunner.class)
public class SimpleMailSenderTest {

    @Mock
    private JavaMailSender mailSender;

    private SimpleMailSender simpleMailSender;

    @Before
    public void setUp() throws Exception {
        simpleMailSender = new SimpleMailSender(mailSender);
    }

    @Test
    public void testSendEmail() {
        EmailDto emailDto = new EmailDto("1","Test tst","test@gmail.com","test","Hello test","2019-12-27","tester");
//        emailDto.setReceiverName("tet test");
//        emailDto.setReceiverEmail("stonesteel84@gmail.com");
//        emailDto.setSubject("unit test");
//        emailDto.setMessage("test passed successfully");
        Mockito.doNothing().when(mailSender).send(Matchers.any(MimeMessagePreparator.class));
        simpleMailSender.sendEmail(emailDto);
        Mockito.verify(mailSender, Mockito.times(1))
                .send(Matchers.any(MimeMessagePreparator.class));
    }
}