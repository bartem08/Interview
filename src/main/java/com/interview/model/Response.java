package com.interview.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "valueOf")
public class Response {

    private String message;
}
