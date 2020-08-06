package com.github.fgsantana.citiesdapi.cities.service;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    CityRepository repo;
    public Page<City> getAllCities(Pageable page) {
        return repo.findAll(page);
    }

    public Optional<City> getCityById(Long id) {
        return repo.findById(id);
    }
}
