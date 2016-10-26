package com.interview.model.entity;

import com.interview.model.IModel;
import com.interview.model.TQuestionId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data @Entity
@Table(name = "template_question")
@EqualsAndHashCode
@IdClass(TQuestionId.class)
public class TemplateQuestion implements IModel<TQuestionId> {

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;

    private Double maxGrade;

    @Override
    public TQuestionId getId() {
        return TQuestionId.of(template, question);
    }
}
