package com.interview.model.projection;

import lombok.*;

@Data
@Builder
public class QuestionInfo {

    String id;

    String topic;

    String question;
}
