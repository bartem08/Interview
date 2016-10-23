package com.interview.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response {

    private HttpStatus status;

    private String message;
}
