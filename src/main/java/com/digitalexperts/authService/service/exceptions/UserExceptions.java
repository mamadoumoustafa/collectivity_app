package com.digitalexperts.authService.service.exceptions;

import java.util.Date;

public class UserExceptions extends Exception {
    private final String message;
    private final Date date;

    public UserExceptions(String message, Date date) {
        this.message = message;
        this.date = date;
    }
}
