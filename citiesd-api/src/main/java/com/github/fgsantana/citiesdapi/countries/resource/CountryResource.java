package com.github.fgsantana.citiesdapi.countries.resource;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import com.github.fgsantana.citiesdapi.countries.exception.CountryNotFoundException;
import com.github.fgsantana.citiesdapi.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/countries")
public class CountryResource {
    @Autowired
    CountryService service;

    public CountryResource() {
    }

    @GetMapping
    public Page<Country> getCountries(Pageable pag) {
        return this.service.getCountries(pag);
    }

    @GetMapping("/{country}")
    public Country getByNameOrId(@PathVariable("country") String country) throws CountryNotFoundException {
        return service.getByNameOrId(country);
    }
}
