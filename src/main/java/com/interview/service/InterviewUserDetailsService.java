package com.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class InterviewUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public InterviewUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        return userService.findByPhone(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
