package com.example.email.dtos.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmailSenderResponse {
    private HttpStatus httpStatus;
    private String message;
}
