package com.example.email.service;

import com.example.email.dtos.requests.SendEmailWithAttachmentRequest;
import com.example.email.dtos.requests.SendMessageRequest;
import com.example.email.dtos.response.EmailSenderResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderService implements EmailSender {
    private final JavaMailSender javaMailSender;
    private Logger logger = LoggerFactory.getLogger(EmailSenderService.class);
    @Override
    public EmailSenderResponse sendEmail(SendMessageRequest sendMessageRequest) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sendMessageRequest.getFrom());
        mailMessage.setTo(sendMessageRequest.getTo());
        mailMessage.setSubject(sendMessageRequest.getSubject());
        mailMessage.setText(sendMessageRequest.getMessage());
        javaMailSender.send(mailMessage);
        return getEmailSenderResponse(sendMessageRequest);
    }

    private EmailSenderResponse getEmailSenderResponse(SendMessageRequest sendMessageRequest) {
        EmailSenderResponse response = new EmailSenderResponse();
        response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Email sent successfully to "+ sendMessageRequest.getTo());
        return response;
    }

    @Override
    public EmailSenderResponse sendEmailWithAttachment(SendEmailWithAttachmentRequest sendEmailWithAttachmentRequest){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(sendEmailWithAttachmentRequest.getTo());
            mimeMessageHelper.setFrom(sendEmailWithAttachmentRequest.getFrom());
            mimeMessageHelper.setSubject(sendEmailWithAttachmentRequest.getSubject());
            mimeMessageHelper.setText(sendEmailWithAttachmentRequest.getMessage());
            File file = new File(sendEmailWithAttachmentRequest.getAttachment());
            FileSystemResource resource = new FileSystemResource(file);
            mimeMessageHelper.addAttachment(resource.getFilename(), resource);
            javaMailSender.send(mimeMessage);
        }catch (MessagingException ex){
            logger.info("Logged --> " + ex.getMessage());
        }
        return getEmailSenderResponse(sendEmailWithAttachmentRequest);
    }

}
