package com.example.email.utils;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
public class ApiResponse {
    private ZonedDateTime timeStamp;
    private HttpStatus statusCode;
    private String path;
    private  Object data;
    private Boolean isSuccessful;
}