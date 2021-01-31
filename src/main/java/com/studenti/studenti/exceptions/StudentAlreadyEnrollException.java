package com.studenti.studenti.exceptions;

public class StudentAlreadyEnrollException extends RuntimeException{

    public StudentAlreadyEnrollException() {
    }

    public StudentAlreadyEnrollException(String message) {
        super(message);
    }

    public StudentAlreadyEnrollException(String message, Throwable cause) {
        super(message, cause);
    }
}
