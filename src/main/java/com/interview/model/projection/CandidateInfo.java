package com.interview.model.projection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateInfo {

    private Title title;

    private String phone;

    private String email;

    private String dateOfBirth;
}
