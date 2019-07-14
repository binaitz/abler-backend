package io.github.binaitz.alberauth.domain.entity;

import io.github.binaitz.alberauth.enums.Role;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AuthorityId implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private Long userId;

    @EqualsAndHashCode.Include
    @Id
    @Enumerated(EnumType.STRING)
    private Role role;
}
