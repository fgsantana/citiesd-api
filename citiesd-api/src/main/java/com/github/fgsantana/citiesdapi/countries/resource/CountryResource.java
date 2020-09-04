//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.github.fgsantana.citiesdapi.countries.resource;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import com.github.fgsantana.citiesdapi.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping({"api/countries"})
public class CountryResource {
    @Autowired
    CountryService service;

    public CountryResource() {
    }

    @GetMapping
    public Page<Country> getCountries(Pageable pag) {
        return this.service.getAllCountries(pag);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity getCountry(@PathVariable("id") Long id) {
        Optional<Country> op = this.service.getCountryById(id);
        return op.isPresent() ? ResponseEntity.ok().body((Country)op.get()) : ResponseEntity.notFound().build();
    }
}
