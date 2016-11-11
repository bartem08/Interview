package com.interview.model;

import com.interview.model.entity.Question;
import com.interview.model.entity.Template;
import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TQuestionId implements Serializable {

    private Template template;

    private Question question;
}
