package com.global.bookproject.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AutherErrorResponce {

            private int status;
            private String message;
            private long timestamp;

    public AutherErrorResponce(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public AutherErrorResponce() {
    }
}
