package io.github.binaitz.alberapi.boasting.service;

import io.github.binaitz.alberapi.boasting.domain.entity.Boasting;
import io.github.binaitz.alberapi.boasting.web.dto.AddBoastingRequest;

public interface AddBoastingService {

    Boasting addBoasting(AddBoastingRequest request, Long userId);
}
