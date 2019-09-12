package io.github.binaitz.alberapi.boasting.service;

import io.github.binaitz.alberapi.boasting.domain.entity.Boasting;
import io.github.binaitz.alberapi.boasting.domain.repository.BoastingRepository;
import io.github.binaitz.alberapi.common.enums.PostCategory;
import io.github.binaitz.alberapi.common.enums.PostOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetBoastingServiceImpl implements GetBoastingService {

    private final BoastingRepository boastingRepository;

    @Override
    public List<Boasting> getBoastings(String keyword, List<PostCategory> categories, PostOrder order) {
        return boastingRepository.findByTitleIgnoreCaseContaining(keyword).stream()
                .filter(boasting -> categories.contains(boasting.getCategory()))
                .sorted(order.getComparator())
                .collect(Collectors.toList());
    }
}
