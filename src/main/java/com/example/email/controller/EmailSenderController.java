package com.example.email.controller;

import com.example.email.dtos.requests.SendEmailWithAttachmentRequest;
import com.example.email.dtos.requests.SendMessageRequest;
import com.example.email.service.EmailSender;
import com.example.email.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mail")
public class EmailSenderController {
    private final EmailSender emailSender;

    @PostMapping("/send")
    public ResponseEntity<ApiResponse> sendMail(@RequestBody SendMessageRequest request, HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .data(emailSender.sendEmail(request))
                .statusCode(HttpStatus.OK)
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/send-with-attachment")
    public ResponseEntity<ApiResponse> sendMail(@RequestBody SendEmailWithAttachmentRequest request, HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .data(emailSender.sendEmailWithAttachment(request))
                .statusCode(HttpStatus.OK)
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
