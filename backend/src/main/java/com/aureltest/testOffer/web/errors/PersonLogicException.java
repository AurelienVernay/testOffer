package com.aureltest.testOffer.web.errors;

public class PersonLogicException extends RuntimeException {
    /**
     * Constructor with only a message
     * 
     * @param message
     */
    public PersonLogicException(String message) {
        super(message, null);
    }

    /**
     * Contructor with message and cause
     * 
     * @param message
     * @param cause
     */
    public PersonLogicException(String message, Throwable cause) {
        super(message, cause);
    }

}