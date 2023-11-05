package com.hensoares.application.mock.exceptions;

import com.hensoares.domain.entity.mock.MockMethodType;

public class MockNotFoundException extends RuntimeException{

    public static final String DEFAULT_ERROR_MESSAGE = "Was not possible to find any mocks with path: %s and method: %s";

    public MockNotFoundException(final String path, final MockMethodType methodType) {
        super(String.format(DEFAULT_ERROR_MESSAGE, path, methodType));
    }


    public MockNotFoundException(String message) {
        super(message);
    }

    public MockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockNotFoundException(Throwable cause) {
        super(cause);
    }
}
