package io.github.binaitz.ablerauth.domain.repository;

import io.github.binaitz.ablerauth.domain.entity.Authority;
import io.github.binaitz.ablerauth.domain.entity.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

    List<Authority> findByUserId(Long userId);
}
