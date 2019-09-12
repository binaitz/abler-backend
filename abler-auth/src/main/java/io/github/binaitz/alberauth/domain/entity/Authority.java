package io.github.binaitz.alberauth.domain.entity;

import io.github.binaitz.alberauth.enums.Role;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@IdClass(AuthorityId.class)
public class Authority {

    @Id
    private Long userId;

    @Id
    private Role role;
}
