package com.global.bookproject.exception;

public class AutherMinRateException extends RuntimeException{
    public AutherMinRateException(String message) {
        super(message);
    }

    public AutherMinRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutherMinRateException(Throwable cause) {
        super(cause);
    }
}
