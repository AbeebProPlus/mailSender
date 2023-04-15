package com.example.email.service;

import com.example.email.dtos.requests.SendEmailWithAttachmentRequest;
import com.example.email.dtos.requests.SendMessageRequest;
import com.example.email.dtos.response.EmailSenderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailSenderServiceTest {

    @Autowired
    private EmailSender emailSender;


    @Test
    void sendEmail() {
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setTo("mdahlat94@gmail.com");
        sendMessageRequest.setFrom("abeebahmad24@gmail.com");
        sendMessageRequest.setSubject("Urgent text urgent");
        sendMessageRequest.setMessage("Urgent text urgent");
        EmailSenderResponse response = emailSender.sendEmail(sendMessageRequest);
        assertEquals(HttpStatus.OK, response.getHttpStatus());
    }

    @Test
    void sendEmailWithAttachment() {
        SendEmailWithAttachmentRequest sendMessageRequest = new SendEmailWithAttachmentRequest();
        sendMessageRequest.setTo("mdahlat94@gmail.com");
        sendMessageRequest.setFrom("abeebahmad24@gmail.com");
        sendMessageRequest.setSubject("Urgent text urgent");
        sendMessageRequest.setMessage("Urgent text urgent");
        sendMessageRequest.setAttachment("C:\\Users\\USER\\Downloads\\island.jpg");
        EmailSenderResponse response = emailSender.sendEmailWithAttachment(sendMessageRequest);
        assertEquals(HttpStatus.OK, response.getHttpStatus());
    }
}
