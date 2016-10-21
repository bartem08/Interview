package com.interview.model.entity;

import lombok.*;
import com.interview.model.AbstractModel;
import com.interview.model.InterviewUserDetails;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data @Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "online_user")
@EqualsAndHashCode(callSuper = false, of = "phone")
public class User extends AbstractModel implements InterviewUserDetails {

    private static final long serialVersionUID = 7672079542738527281L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    @Email
    private String email;

    @Pattern(regexp = "^[0][1-9][0-9]{8}")
    private String phone;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "online_user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Role> authorities;
}
