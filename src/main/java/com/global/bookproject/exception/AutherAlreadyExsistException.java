package com.global.bookproject.exception;

public class AutherAlreadyExsistException extends  RuntimeException{
    public AutherAlreadyExsistException(String message) {
        super(message);
    }

    public AutherAlreadyExsistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutherAlreadyExsistException(Throwable cause) {
        super(cause);
    }
}
