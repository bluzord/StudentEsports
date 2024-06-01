package com.studentesports.backend.exceptions;

public class ApplicationsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public ApplicationsNotFoundException(String message) {
        super(message);
    }
}
