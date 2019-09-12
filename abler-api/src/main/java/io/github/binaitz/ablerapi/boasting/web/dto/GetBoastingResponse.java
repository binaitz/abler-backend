package io.github.binaitz.ablerapi.boasting.web.dto;

import io.github.binaitz.ablerapi.boasting.domain.entity.Boasting;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public class GetBoastingResponse {

    private List<BoastingDto> boastings;

    public static GetBoastingResponse from(List<Boasting> boastings) {
        List<BoastingDto> boastingDtoList = new ArrayList<>();
        for (Boasting boasting : boastings) {
            boastingDtoList.add(
                    BoastingDto.builder()
                            .title(boasting.getTitle())
                            .userName(boasting.getCreatedBy().getName())
                            .numberOfLikes(boasting.getNumberOfLikes())
                            .build()
            );
        }
        return new GetBoastingResponse(boastingDtoList);
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    protected static class BoastingDto {
        private String title;
        private String userName;
        private int numberOfLikes;
    }
}
