package io.github.binaitz.alberapi.user.service;

import io.github.binaitz.alberapi.user.web.SignInRequest;
import io.github.binaitz.alberapi.user.web.SignUpRequest;

public interface SignInService {

    String signIn(SignInRequest request);
}
