package com.example.email.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendMessageRequest {
    private String to;
    private String from;
    private String subject;
    private String message;

    public SendMessageRequest(){}
}
