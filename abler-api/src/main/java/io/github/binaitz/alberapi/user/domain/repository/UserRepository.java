package io.github.binaitz.alberapi.user.domain.repository;

import io.github.binaitz.alberapi.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);
}
