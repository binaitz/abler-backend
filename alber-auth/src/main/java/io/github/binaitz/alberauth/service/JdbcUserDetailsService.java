package io.github.binaitz.alberauth.service;

import io.github.binaitz.alberauth.domain.entity.User;
import io.github.binaitz.alberauth.domain.repository.UserRepository;
import io.github.binaitz.alberauth.exception.UserIdNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JdbcUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(s)
                .orElseThrow(UserIdNotExistException::new);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));

        return new AblerUserDetails(user.getId(), user.getUserId(), user.getPassword(), authorities);
    }
}
