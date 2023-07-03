package com.global.bookproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AutherErrorResponce> handleException(AutherNotFoundException exc) {

        AutherErrorResponce error = new AutherErrorResponce();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }
    // Add another excpetion hanlder to cath anyaother
    // @ExceptionHandler
    // public ResponseEntity<AutherErrorResponce> handleExcpetion(Exception exjc){

    //    AutherErrorResponce error = new AutherErrorResponce();
    //    error.setStatus(HttpStatus.BAD_REQUEST.value());
    //   error.setMessage("It is not allowed to search with String");
    //    error.setTimestamp(System.currentTimeMillis());
    //    return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    // }

    @ExceptionHandler
    public ResponseEntity<AutherErrorResponce> handleExcpetion(AutherMinRateException exx){
        AutherErrorResponce error = new AutherErrorResponce();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exx.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<AutherErrorResponce> handleExcpetion(AutherAlreadyExsistException exx){
        AutherErrorResponce error = new AutherErrorResponce();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exx.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AutherErrorResponce> handleExcpetion(AutherNumberOfBookException exx){
        AutherErrorResponce error = new AutherErrorResponce();
        error.setStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value());
        error.setMessage(exx.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
}
