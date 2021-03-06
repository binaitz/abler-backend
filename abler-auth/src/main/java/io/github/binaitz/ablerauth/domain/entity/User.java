package io.github.binaitz.ablerauth.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
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
