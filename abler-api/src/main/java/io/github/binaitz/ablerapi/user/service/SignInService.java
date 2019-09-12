package io.github.binaitz.ablerapi.user.service;

import io.github.binaitz.ablerapi.user.web.dto.SignInRequest;

public interface SignInService {

    String signIn(SignInRequest request);
}
