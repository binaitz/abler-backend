package io.github.binaitz.ablerauth.domain.entity;

import io.github.binaitz.ablerauth.enums.Role;
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
