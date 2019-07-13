package io.github.binaitz.alberapi.user.web.dto;

import io.github.binaitz.alberapi.user.service.SignInService;
import io.github.binaitz.alberapi.user.service.SignUpService;
import io.github.binaitz.alberapi.user.web.dto.SignInRequest;
import io.github.binaitz.alberapi.user.web.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping
    public void signUp(SignUpRequest request) {
        signUpService.signUp(request);
    }

    @PostMapping
    public void signIn(SignInRequest request) {
        signInService.signIn(request);
    }
}
