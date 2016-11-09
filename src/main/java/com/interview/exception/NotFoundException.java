package com.interview.exception;

import lombok.Getter;

public class NotFoundException extends InterviewException {

    @Getter
    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
