package io.github.binaitz.alberapi.user.service.impl;

import io.github.binaitz.alberapi.user.domain.entity.User;
import io.github.binaitz.alberapi.user.domain.repository.UserRepository;
import io.github.binaitz.alberapi.user.service.SignInService;
import io.github.binaitz.alberapi.user.web.OAuth2TokenResponse;
import io.github.binaitz.alberapi.user.web.SignInRequest;
import io.github.binaitz.alberapi.user.web.SignUpRequest;
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
