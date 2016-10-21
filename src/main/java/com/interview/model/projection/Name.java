package com.interview.model.projection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Name {

    String firstName;

    String lastName;
}
