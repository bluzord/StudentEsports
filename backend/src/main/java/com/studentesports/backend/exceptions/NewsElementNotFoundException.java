package com.studentesports.backend.exceptions;

public class NewsElementNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public NewsElementNotFoundException(String message) {
        super(message);
    }
}
