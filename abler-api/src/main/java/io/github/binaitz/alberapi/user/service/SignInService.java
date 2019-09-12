package io.github.binaitz.alberapi.user.service;

import io.github.binaitz.alberapi.user.web.dto.SignInRequest;

public interface SignInService {

    String signIn(SignInRequest request);
}
