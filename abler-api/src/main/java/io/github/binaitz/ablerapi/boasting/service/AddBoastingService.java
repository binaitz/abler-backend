package io.github.binaitz.ablerapi.boasting.service;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import io.github.binaitz.ablerapi.boasting.web.dto.AddBoastingRequest;

public interface AddBoastingService {

    Boasting addBoasting(AddBoastingRequest request, Long userId);
}
