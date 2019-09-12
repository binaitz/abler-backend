package io.github.binaitz.ablerauth.domain.repository;

import io.github.binaitz.ablerauth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
