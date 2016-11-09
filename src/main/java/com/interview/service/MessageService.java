package com.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private MessageSource messageSource;

    @Autowired
    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code) {
        return messageSource
                .getMessage(code, null, Locale.getDefault());
    }

    public String getMessage(String code, Object param) {
        return messageSource
                .getMessage(code, new Object[] { param }, Locale.getDefault());
    }

    public String getMessage(String code, Object[] params) {
        return messageSource
                .getMessage(code, params, Locale.getDefault());
    }

    public String getMessage(String code, String label, Object param) {
        Object[] params = new Object[] { getMessage(label), param };
        return getMessage(code, params);
    }

    public String getMessage(String code, String label) {
        return getMessage(code, label, null);
    }
}
