package io.github.binaitz.ablerapi.user.service;

import io.github.binaitz.ablerapi.user.domain.entity.User;
import io.github.binaitz.ablerapi.user.web.dto.SignUpRequest;

public interface SignUpService {

    User signUp(SignUpRequest request);
}
