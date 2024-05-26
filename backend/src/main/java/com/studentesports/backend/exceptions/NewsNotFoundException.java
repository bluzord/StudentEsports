package com.studentesports.backend.exceptions;

public class NewsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public NewsNotFoundException(String message) {
        super(message);
    }
}
