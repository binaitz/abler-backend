package io.github.binaitz.ablerapi.common.enums;

import io.github.binaitz.ablerapi.common.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@AllArgsConstructor
@Getter
public enum PostOrder {

    LIKE("좋아요순", (post1, post2) ->
            Integer.compare(post1.getNumberOfLikes(), post2.getNumberOfLikes())
    ),
    COMMENT("댓글순", (post1, post2) ->
            Integer.compare(post1.getNumberOfComments(), post2.getNumberOfComments())
    ),
    RECENT("최신순", (post1, post2) ->
            post1.getCreatedAt().compareTo(post2.getCreatedAt())
    );

    private String value;
    private Comparator<Post> comparator;
}
