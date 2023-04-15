package com.example.email.service;

import com.example.email.dtos.requests.SendEmailWithAttachmentRequest;
import com.example.email.dtos.requests.SendMessageRequest;
import com.example.email.dtos.response.EmailSenderResponse;
import jakarta.mail.MessagingException;

public interface EmailSender {
    EmailSenderResponse sendEmail(SendMessageRequest sendMessageRequest);
    EmailSenderResponse sendEmailWithAttachment(SendEmailWithAttachmentRequest sendEmailWithAttachmentRequest);
}
