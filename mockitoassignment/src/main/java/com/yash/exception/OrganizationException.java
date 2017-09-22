package com.yash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR,reason="Something Went Wrong")
public class OrganizationException extends RuntimeException {

    public OrganizationException() {
        super();
    }
}
