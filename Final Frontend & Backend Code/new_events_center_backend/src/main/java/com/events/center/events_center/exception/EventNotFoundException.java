package com.events.center.events_center.exception;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EventNotFoundException(String msg) {
        super(msg);
    }
}


