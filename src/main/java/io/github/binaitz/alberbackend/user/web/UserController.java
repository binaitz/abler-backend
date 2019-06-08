package io.github.binaitz.alberbackend.user.web;

import io.github.binaitz.alberbackend.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final SignUpService signUpService;

    @PostMapping
    public void signUp(SignUpRequest request) {
        signUpService.signUp(request);
    }
}
