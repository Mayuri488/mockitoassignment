package com.yash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
//@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="This organization is not found in the system")
public class OrganizationNotFoundException extends RuntimeException {


    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public OrganizationNotFoundException() {
        super();
    }

    public OrganizationNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
