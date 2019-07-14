package io.github.binaitz.alberapi.boasting.service;

import io.github.binaitz.alberapi.boasting.domain.entity.Boasting;
import io.github.binaitz.alberapi.boasting.domain.repository.BoastingRepository;
import io.github.binaitz.alberapi.boasting.web.dto.AddBoastingRequest;
import io.github.binaitz.alberapi.common.enums.PostCategory;
import io.github.binaitz.alberapi.common.enums.PostOrder;
import io.github.binaitz.alberapi.user.domain.entity.User;
import io.github.binaitz.alberapi.user.domain.repository.UserRepository;
import io.github.binaitz.alberapi.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
