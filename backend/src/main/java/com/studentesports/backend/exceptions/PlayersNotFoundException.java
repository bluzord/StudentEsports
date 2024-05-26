package com.studentesports.backend.exceptions;

public class PlayersNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PlayersNotFoundException(String message) {
        super(message);
    }
}
