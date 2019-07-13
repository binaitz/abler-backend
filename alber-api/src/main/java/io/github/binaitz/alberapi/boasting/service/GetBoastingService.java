package io.github.binaitz.alberapi.boasting.service;

import io.github.binaitz.alberapi.boasting.domain.entity.Boasting;
import io.github.binaitz.alberapi.common.enums.PostCategory;
import io.github.binaitz.alberapi.common.enums.PostOrder;

import java.util.List;

public interface GetBoastingService {

    List<Boasting> getBoastings(String keyword, List<PostCategory> categories, PostOrder order);
}
