package com.github.fgsantana.citiesdapi.countries.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(){
        super("Country not found");
    }
}