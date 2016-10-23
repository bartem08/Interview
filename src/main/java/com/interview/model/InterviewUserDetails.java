package com.interview.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface InterviewUserDetails extends UserDetails {

    String getPhone();

    @Override
    default boolean isAccountNonExpired() {
        return true;
    }

    @Override
    default boolean isAccountNonLocked() {
        return true;
    }

    @Override
    default boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    default String getUsername() {
        return getPhone();
    }
}
