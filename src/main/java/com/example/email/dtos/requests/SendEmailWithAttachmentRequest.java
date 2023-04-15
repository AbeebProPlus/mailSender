package com.example.email.dtos.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendEmailWithAttachmentRequest extends SendMessageRequest {
    private String attachment;
    public SendEmailWithAttachmentRequest(){}
}
