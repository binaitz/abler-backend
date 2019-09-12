package io.github.binaitz.ablerapi.boasting.domain.entity;

import io.github.binaitz.ablerapi.common.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "boasting_id"))
public class Boasting extends Post {
}
