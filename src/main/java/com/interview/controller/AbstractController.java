package com.interview.controller;

import com.interview.model.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {

    protected User getCurrentUser() {

        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
