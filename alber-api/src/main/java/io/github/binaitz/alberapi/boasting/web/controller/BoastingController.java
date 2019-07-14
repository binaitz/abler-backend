package io.github.binaitz.alberapi.boasting.web.controller;

import io.github.binaitz.alberapi.annotations.UserId;
import io.github.binaitz.alberapi.boasting.domain.entity.Boasting;
import io.github.binaitz.alberapi.boasting.service.AddBoastingService;
import io.github.binaitz.alberapi.boasting.service.GetBoastingService;
import io.github.binaitz.alberapi.boasting.web.dto.AddBoastingRequest;
import io.github.binaitz.alberapi.boasting.web.dto.GetBoastingResponse;
import io.github.binaitz.alberapi.common.enums.PostCategory;
import io.github.binaitz.alberapi.common.enums.PostOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoastingController {

    private final GetBoastingService getBoastingService;
    private final AddBoastingService addBoastingService;

    @GetMapping("/boastings")
    public GetBoastingResponse getBoastings(@RequestParam String keyword, @RequestParam List<PostCategory> categories,
                                                  @RequestParam PostOrder order) {

        List<Boasting> boastings = getBoastingService.getBoastings(keyword, categories, order);
        return GetBoastingResponse.from(boastings);
    }

    @PostMapping("/boastings")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void addBoasting(@UserId Long userId, @RequestBody AddBoastingRequest request) {
        addBoastingService.addBoasting(request, userId);
    }
}
