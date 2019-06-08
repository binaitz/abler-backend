package io.github.binaitz.alberapi.user.web;

import io.github.binaitz.alberapi.user.domain.entity.User;
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
