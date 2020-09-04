package com.github.fgsantana.citiesdapi.cities.resource;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {
    @Autowired
    CityService service;

    public CityResource() {
    }

    @GetMapping
    public Page<City> getCities(Pageable page) {
        return this.service.getAllCities(page);
    }




    @GetMapping("/{city}")
    public List<City> getCityByNameOrId(@PathVariable("city") String city) {
       return this.service.findByNameOrId(city);
    }
}
