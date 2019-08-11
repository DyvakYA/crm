package com.dyvak.springbootvuejs.exception;

public class TokenIsIncorrectException extends RuntimeException {
    public TokenIsIncorrectException(String jwt_token_is_incorrect) {
    }
}
