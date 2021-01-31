package com.studenti.studenti.exceptions;

public class MaterieNotFoundException extends RuntimeException {

    public MaterieNotFoundException() {
    }

    public MaterieNotFoundException(String message) {
        super(message);
    }

    public MaterieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
