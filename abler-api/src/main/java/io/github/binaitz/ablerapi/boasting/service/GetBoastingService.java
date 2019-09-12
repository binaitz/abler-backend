package io.github.binaitz.ablerapi.boasting.service;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import io.github.binaitz.ablerapi.common.enums.PostCategory;
import io.github.binaitz.ablerapi.common.enums.PostOrder;

import java.util.List;

public interface GetBoastingService {

    List<Boasting> getBoastings(String keyword, List<PostCategory> categories, PostOrder order);
}
