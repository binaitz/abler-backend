package io.github.binaitz.alberauth.service;

import io.github.binaitz.alberauth.domain.entity.Authority;
import io.github.binaitz.alberauth.domain.entity.User;
import io.github.binaitz.alberauth.domain.repository.AuthorityRepository;
import io.github.binaitz.alberauth.domain.repository.UserRepository;
import io.github.binaitz.alberauth.exception.UserIdNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JdbcUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(s)
                .orElseThrow(UserIdNotExistException::new);

        List<Authority> authorities = authorityRepository.findByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(authority -> new RolePrefixedGrantedAuthority(authority.getRole().name()))
                .collect(Collectors.toList());

        return new AblerUserDetails(user.getId(), user.getUserId(), user.getPassword(), grantedAuthorities);
    }
}
