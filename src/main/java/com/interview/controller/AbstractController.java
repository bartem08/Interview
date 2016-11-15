package com.interview.controller;

import com.interview.model.*;
import com.interview.model.entity.*;
import com.interview.model.projection.Title;
import com.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.stream.Collectors;

public abstract class AbstractController {

    protected MessageService messageService;

    @Autowired
    protected AbstractController(MessageService messageService) {
        this.messageService = messageService;
    }

    protected User getCurrentUser() {

        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    protected Title buildTitle(ITitle iTitle) {

        return Title.builder()
                .firstName(iTitle.getFirstName())
                .lastName(iTitle.getLastName())
                .directions(iTitle.getDirections()
                        .stream()
                        .map(Direction::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}
