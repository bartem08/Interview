package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data @Entity
@Table(name = "template")
@EqualsAndHashCode(callSuper = false, of = "name")
public class Template extends AbstractModel {

    private String name;

    @ManyToOne
    @JoinColumn(name = "online_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @OneToMany(mappedBy = "template")
    private Set<TemplateQuestion> questions;

    private boolean favourite;
}
