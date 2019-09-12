package io.github.binaitz.ablerapi.user.web.dto;

import io.github.binaitz.ablerapi.user.service.SignInService;
import io.github.binaitz.ablerapi.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public void signUp(SignUpRequest request) {
        signUpService.signUp(request);
    }

    @PostMapping("/signin")
    public void signIn(SignInRequest request) {
        signInService.signIn(request);
    }
}
