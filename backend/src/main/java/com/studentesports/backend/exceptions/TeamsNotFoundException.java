package com.studentesports.backend.exceptions;

public class TeamsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public TeamsNotFoundException(String message) {
        super(message);
    }
}
