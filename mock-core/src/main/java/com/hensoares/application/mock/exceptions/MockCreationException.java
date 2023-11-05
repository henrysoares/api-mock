package com.hensoares.application.mock.exceptions;

/**
 * Exception that represents an error on persisting a mock on database.
 */
public class MockCreationException extends RuntimeException{
    public MockCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockCreationException(Throwable cause) {
        super(cause);
    }

    public MockCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
