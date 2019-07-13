package io.github.binaitz.alberapi;

import io.github.binaitz.alberapi.user.domain.entity.User;
import io.github.binaitz.alberapi.user.domain.repository.UserRepository;
import io.github.binaitz.alberapi.user.exception.UserAlreadyExistsException;
import io.github.binaitz.alberapi.user.service.SignUpService;
import io.github.binaitz.alberapi.user.web.dto.SignUpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignUpServiceTests {

    private static final String USER_ID = "binaitz";
    private static final String USER_PASSWORD = "test1470";
    private static final String USER_NAME = "조성빈";

    @Autowired
    private SignUpService signUpService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void signUp() {
        // given
        SignUpRequest request = SignUpRequest.builder()
                .id(USER_ID)
                .password(USER_PASSWORD)
                .name(USER_NAME)
                .build();

        User dummyUser = request.toUser();
        given(userRepository.save(any(User.class))).willReturn(dummyUser);

        // when
        User user = signUpService.signUp(request);

        // then
        then(userRepository).should().existsByUserId(USER_ID);
        assertSame(user, dummyUser);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void signUp_아이디_중복_시_UserAlreadyExistsException() {
        // given
        SignUpRequest request = SignUpRequest.builder()
                .id(USER_ID)
                .password(USER_PASSWORD)
                .name(USER_NAME)
                .build();

        given(userRepository.existsByUserId(USER_ID)).willReturn(true);

        // when
        signUpService.signUp(request);
    }
}
