package com.interview.model.entity;

import com.interview.model.AbstractModel;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data @Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_authority")
@EqualsAndHashCode(callSuper = false, of = "authority")
public class Role extends AbstractModel implements GrantedAuthority {

    @Column(name = "authority")
    private String authority;
}
