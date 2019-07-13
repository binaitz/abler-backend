package io.github.binaitz.alberapi.common.entity;

import io.github.binaitz.alberapi.common.enums.PostCategory;
import io.github.binaitz.alberapi.user.domain.entity.User;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@MappedSuperclass
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private PostCategory category;
    private int numberOfLikes;
    private int numberOfComments;

    @ManyToOne
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToMany
    private Set<Tag> tags;
}
