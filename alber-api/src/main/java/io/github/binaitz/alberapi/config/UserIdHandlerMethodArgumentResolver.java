package io.github.binaitz.alberapi.config;

import io.github.binaitz.alberapi.annotations.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
public class UserIdHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String ADDITIONAL_INFORMATION_KEY_USER_ID = "user_id";

    private final TokenStore tokenStore;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        OAuth2AuthenticationDetails details =
                (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        return Integer.toUnsignedLong((Integer) accessToken.getAdditionalInformation().get(ADDITIONAL_INFORMATION_KEY_USER_ID));
    }
}