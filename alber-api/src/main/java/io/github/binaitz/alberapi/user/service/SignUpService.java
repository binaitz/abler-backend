package io.github.binaitz.alberapi.user.service;

import io.github.binaitz.alberapi.user.domain.entity.User;
import io.github.binaitz.alberapi.user.web.SignUpRequest;

public interface SignUpService {

    User signUp(SignUpRequest request);
}
