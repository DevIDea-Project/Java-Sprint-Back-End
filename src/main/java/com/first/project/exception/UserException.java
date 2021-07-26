package com.first.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserException extends Exception{

    private static final long serialVersionUID = 1L;

    public UserException(String message) {
        super(message);
    }
}
