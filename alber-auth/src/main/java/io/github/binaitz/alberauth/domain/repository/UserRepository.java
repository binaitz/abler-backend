package io.github.binaitz.alberauth.domain.repository;

import io.github.binaitz.alberauth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
