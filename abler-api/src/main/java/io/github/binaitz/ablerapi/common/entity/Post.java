package io.github.binaitz.ablerapi.common.entity;

import io.github.binaitz.ablerapi.common.enums.PostCategory;
import io.github.binaitz.ablerapi.user.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private PostCategory category;
    private String tags;
    private int numberOfLikes;
    private int numberOfComments;

    @Setter
    @ManyToOne
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdAt;
}
