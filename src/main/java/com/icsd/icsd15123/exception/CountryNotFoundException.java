package com.icsd.icsd15123.exception;

import java.util.function.Supplier;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
