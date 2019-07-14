package io.github.binaitz.alberauth.domain.repository;

import io.github.binaitz.alberauth.domain.entity.Authority;
import io.github.binaitz.alberauth.domain.entity.AuthorityId;
import io.github.binaitz.alberauth.domain.entity.User;
import io.github.binaitz.alberauth.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

    List<Authority> findByUserId(Long userId);
}
