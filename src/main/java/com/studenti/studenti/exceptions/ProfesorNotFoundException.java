package com.studenti.studenti.exceptions;

public class ProfesorNotFoundException extends RuntimeException{

    public ProfesorNotFoundException() {
    }

    public ProfesorNotFoundException(String message) {
        super(message);
    }

    public ProfesorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
