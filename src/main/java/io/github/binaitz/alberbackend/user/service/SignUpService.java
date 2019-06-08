package io.github.binaitz.alberbackend.user.service;

import io.github.binaitz.alberbackend.user.domain.entity.User;
import io.github.binaitz.alberbackend.user.web.SignUpRequest;

public interface SignUpService {

    User signUp(SignUpRequest request);
}
