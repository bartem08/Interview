package com.interview.model.entity;

import com.interview.model.*;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Data @Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends AbstractModel implements ITitle {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^[0][1-9][0-9]{8}")
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(name = "candidate_direction",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "direction_id"))
    private Set<Direction> directions;
}
