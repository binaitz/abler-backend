package io.github.binaitz.alberapi.user.web.dto;

import io.github.binaitz.alberapi.user.exception.InvalidTokenException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BearerToken {

    private String value;

    private static final Pattern PREFIX_BEARER_PATTERN =
            Pattern.compile("^Bearer *([^ ]+) *$", Pattern.CASE_INSENSITIVE);

    public static BearerToken parse(String header) {
        if (StringUtils.isBlank(header)) {
            throw new InvalidTokenException();
        }

        Matcher matcher = PREFIX_BEARER_PATTERN.matcher(header);

        if (!matcher.matches()) {
            throw new InvalidTokenException();
        }

        return new BearerToken(matcher.group(1));
    }
}
