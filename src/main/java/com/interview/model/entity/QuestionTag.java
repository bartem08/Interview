package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data @Entity
@Table(name = "question_tag")
@EqualsAndHashCode(callSuper = false, of = "name")
public class QuestionTag extends AbstractModel {

    private String name;

    @OneToMany(mappedBy = "questionTag")
    private Set<Question> questions;
}
