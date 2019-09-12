package io.github.binaitz.ablerapi.user.service.impl;

import io.github.binaitz.ablerapi.user.domain.entity.User;
import io.github.binaitz.ablerapi.user.domain.repository.UserRepository;
import io.github.binaitz.ablerapi.user.exception.UserAlreadyExistsException;
import io.github.binaitz.ablerapi.user.service.SignUpService;
import io.github.binaitz.ablerapi.user.web.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    @Override
    public User signUp(SignUpRequest request) {
        if (userRepository.existsByUserId(request.getId())) {
            throw new UserAlreadyExistsException();
        }

        User user = request.toUser();
        return userRepository.save(user);
    }
}
