package io.github.binaitz.alberauth.exception;

public class UserIdNotExistException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "존재하지 않는 아이디입니다.";

    public UserIdNotExistException() {
        super(DEFAULT_MESSAGE);
    }

    public UserIdNotExistException(String message) {
        super(message);
    }
}
