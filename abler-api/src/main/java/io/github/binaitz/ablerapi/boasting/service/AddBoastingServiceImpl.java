package io.github.binaitz.ablerapi.boasting.service;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import io.github.binaitz.ablerapi.boasting.domain.repository.BoastingRepository;
import io.github.binaitz.ablerapi.boasting.web.dto.AddBoastingRequest;
import io.github.binaitz.ablerapi.user.domain.entity.User;
import io.github.binaitz.ablerapi.user.domain.repository.UserRepository;
import io.github.binaitz.ablerapi.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddBoastingServiceImpl implements AddBoastingService {

    private final BoastingRepository boastingRepository;
    private final UserRepository userRepository;

    @Override
    public Boasting addBoasting(AddBoastingRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        Boasting boasting = request.toBoasting();
        boasting.setCreatedBy(user);
        return boastingRepository.save(boasting);
    }
}
