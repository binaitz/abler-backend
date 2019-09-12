package io.github.binaitz.ablerapi.user.web.dto;

import io.github.binaitz.ablerapi.user.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpRequest {

    private String id;
    private String password;
    private String name;

    public User toUser() {
        return User.builder()
                .userId(id)
                .password(password)
                .name(name)
                .build();
    }
}
