package io.github.binaitz.ablerapi.user.domain.repository;

import io.github.binaitz.ablerapi.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);
}
