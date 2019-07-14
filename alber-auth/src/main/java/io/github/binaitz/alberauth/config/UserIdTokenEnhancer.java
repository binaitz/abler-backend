package io.github.binaitz.alberauth.config;

import io.github.binaitz.alberauth.service.AblerUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class UserIdTokenEnhancer implements TokenEnhancer {

    private static final String ADDITIONAL_INFORMATION_KEY_USER_ID = "user_id";

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        AblerUserDetails userDetails = ((AblerUserDetails) oAuth2Authentication.getUserAuthentication().getPrincipal());

        Map<String, Object> additionalInformation = new HashMap<>();
        additionalInformation.put(ADDITIONAL_INFORMATION_KEY_USER_ID, userDetails.getId());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInformation);

        return oAuth2AccessToken;
    }
}
