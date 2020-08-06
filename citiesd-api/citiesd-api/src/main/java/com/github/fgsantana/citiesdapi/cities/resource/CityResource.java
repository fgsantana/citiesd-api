package com.github.fgsantana.citiesdapi.cities.resource;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.service.CityService;
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
@RequestMapping({"api/cities"})
public class CityResource {
    @Autowired
    CityService service;

    public CityResource() {
    }

    @GetMapping
    public Page<City> getCities(Pageable page) {
        return this.service.getAllCities(page);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity getCity(@PathVariable("id") Long id) {
        Optional<City> op = this.service.getCityById(id);
        return op.isPresent() ? ResponseEntity.ok().body((City)op.get()) : ResponseEntity.notFound().build();
    }
}
