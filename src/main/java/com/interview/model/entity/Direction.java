package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data @Entity
@Table(name = "direction")
@EqualsAndHashCode(callSuper = false, of = "name")
public class Direction extends AbstractModel {

    private String name;

    @ManyToMany(mappedBy = "directions")
    private Set<Candidate> candidates;

    @ManyToMany(mappedBy = "directions")
    private Set<User> users;
}
