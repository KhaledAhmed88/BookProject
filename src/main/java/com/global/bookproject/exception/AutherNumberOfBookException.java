package com.global.bookproject.exception;

public class AutherNumberOfBookException extends RuntimeException{
    public AutherNumberOfBookException(String message) {
        super(message);
    }

    public AutherNumberOfBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutherNumberOfBookException(Throwable cause) {
        super(cause);
    }
}
