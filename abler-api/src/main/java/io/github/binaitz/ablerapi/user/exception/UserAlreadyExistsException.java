package io.github.binaitz.ablerapi.user.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "이미 존재하는 아이디입니다.";

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
