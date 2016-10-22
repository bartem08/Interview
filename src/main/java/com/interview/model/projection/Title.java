package com.interview.model.projection;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Title {

    private String firstName;

    private String lastName;

    private Set<String> directions;
}
