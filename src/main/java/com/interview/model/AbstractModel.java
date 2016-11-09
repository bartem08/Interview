package com.interview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public class AbstractModel implements IModel<String> {

    @Id
    private String id;

    @PrePersist
    void prePersist() {
        id = UUID.randomUUID().toString();
    }
}
