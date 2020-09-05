package com.github.fgsantana.citiesdapi.states.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class StateNotFoundException extends Exception {
    public StateNotFoundException() {
        super("State not found");
    }
}