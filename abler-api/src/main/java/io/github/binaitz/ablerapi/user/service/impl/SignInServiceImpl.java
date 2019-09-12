package io.github.binaitz.ablerapi.user.service.impl;

import io.github.binaitz.ablerapi.user.domain.repository.UserRepository;
import io.github.binaitz.ablerapi.user.service.SignInService;
import io.github.binaitz.ablerapi.user.web.controller.OAuth2TokenResponse;
import io.github.binaitz.ablerapi.user.web.dto.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final UserRepository userRepository;

    @Override
    public String signIn(SignInRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("username", request.getId());
        params.put("password", request.getPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("abler", "secret"));
        OAuth2TokenResponse response =
                restTemplate.postForObject("http://localhost:8081/oauth/token", params, OAuth2TokenResponse.class);

        return response.getAccessToken();
    }
}
