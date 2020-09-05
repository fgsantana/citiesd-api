package com.github.fgsantana.citiesdapi.cities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParamException extends Exception {
    public InvalidParamException(){
        super("'by' param must be 'id' or 'name'");
    }
}
