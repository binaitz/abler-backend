package io.github.binaitz.alberapi.user.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "id")
    private String userId;

    private String password;
    private String name;

    @CreatedDate
    private LocalDateTime createdAt;
}
