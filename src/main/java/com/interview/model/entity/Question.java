package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data @Entity
@Table(name = "question")
@EqualsAndHashCode(callSuper = false, of = "content")
public class Question extends AbstractModel {

    private String content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private QuestionTag questionTag;

    @OneToMany(mappedBy = "question")
    private Set<TemplateQuestion> templates;
}
