package io.github.binaitz.alberapi.user.web.dto;

import lombok.Getter;

@Getter
public class SignInRequest {

    private String id;
    private String password;
}
