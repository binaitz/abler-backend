package io.github.binaitz.ablerapi.boasting.web.dto;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import io.github.binaitz.ablerapi.common.enums.PostCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBoastingRequest {

    private String title;
    private PostCategory category;
    private String content;
    private String tags;

    public Boasting toBoasting() {
        return Boasting.builder()
                .title(title)
                .category(category)
                .content(content)
                .tags(tags)
                .build();
    }
}
