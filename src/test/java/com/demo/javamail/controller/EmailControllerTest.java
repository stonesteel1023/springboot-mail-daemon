package com.demo.javamail.controller;

import com.demo.javamail.resources.EmailDto;
import com.demo.javamail.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 @Author Milan Paudyal
 @Date 5/12/19, Sun
*/

public class EmailControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
    }

    @Test
    public void testSendEmail() throws Exception {
        Mockito.doNothing().when(emailService).sendEmail(org.mockito.Matchers.any(EmailDto.class));
        mockMvc.perform(MockMvcRequestBuilders.post("/send"))
                .andExpect(status().isOk());
    }
}