package io.github.binaitz.ablerauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class RolePrefixedGrantedAuthority implements GrantedAuthority {

    private static final String PREFIX = "ROLE_";

    private final String role;

    @Override
    public String getAuthority() {
        return PREFIX + role;
    }
}
