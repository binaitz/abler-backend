package io.github.binaitz.ablerapi.boasting.domain.repository;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoastingRepository extends JpaRepository<Boasting, Long> {

    List<Boasting> findByTitleIgnoreCaseContaining(String keyword);
}
