package com.open.lms.exceptions;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message, Exception e) {
        super(message, e);
    }

    public ApplicationException(String message) {
        super(message);
    }
}
