package io.github.binaitz.ablerapi.common.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum PostCategory {

    MUSICAL_INSTRUMENT("악기"),
    SINGING("노래"),
    DANCING("춤"),
    BAKING("베이킹"),
    COOKING("요리"),
    PHOTOGRAPHY("사진"),
    ART("미술"),
    CARTOON("만화"),
    ILLUSTRATION("일러스트"),
    ASSEMBLING("조립"),
    CRAFT("공예"),
    FASSION("패션"),
    ESSAY("작문"),
    WORKOUT("운동"),
    ACCESSORY("액세서리");

    private String value;
}
