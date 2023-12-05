package com.events.center.events_center.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}


