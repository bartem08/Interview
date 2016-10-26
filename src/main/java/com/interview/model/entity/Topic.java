package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data @Entity
@Table(name = "topic")
@EqualsAndHashCode(callSuper = false, of = "topic")
public class Topic extends AbstractModel {

    private String topic;

    @OneToMany(mappedBy = "topic")
    private Set<Question> questions;
}
