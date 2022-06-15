package com.project.exception;


// к SessionFactoryInitialization
public class PreparationNotStarted extends Exception{
    public PreparationNotStarted() {
        super();
    }

    public PreparationNotStarted(String message) {
        super(message);
    }

    public PreparationNotStarted(String message, Throwable cause) {
        super(message, cause);
    }

    public PreparationNotStarted(Throwable cause) {
        super(cause);
    }
}
