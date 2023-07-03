package com.global.bookproject.exception;

public class AutherNotFoundException extends RuntimeException{
    public AutherNotFoundException(String message) {
        super(message);
    }

    public AutherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutherNotFoundException(Throwable cause) {
        super(cause);
    }
}
