package io.github.binaitz.alberapi.user.service.impl;

import io.github.binaitz.alberapi.user.domain.entity.User;
import io.github.binaitz.alberapi.user.domain.repository.UserRepository;
import io.github.binaitz.alberapi.user.exception.UserAlreadyExistsException;
import io.github.binaitz.alberapi.user.service.SignUpService;
import io.github.binaitz.alberapi.user.web.dto.SignUpRequest;
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
