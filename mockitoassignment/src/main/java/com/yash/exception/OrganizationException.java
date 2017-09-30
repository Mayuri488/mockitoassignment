package com.yash.exception;


public class OrganizationException extends RuntimeException {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public OrganizationException() {
        super();
    }

    public OrganizationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
