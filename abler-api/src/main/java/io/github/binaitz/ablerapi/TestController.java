package io.github.binaitz.ablerapi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PreAuthorize("#id == authentication.name")
    @GetMapping("/{id}")
    public String userMe(@PathVariable String id) {
        return id;
    }
}
