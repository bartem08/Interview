package com.interview.controller;

import com.interview.model.ITitle;
import com.interview.model.entity.Direction;
import com.interview.model.entity.User;
import com.interview.model.projection.Title;
import com.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.stream.Collectors;

public abstract class AbstractController {

    @Autowired
    protected MessageService messageService;

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
