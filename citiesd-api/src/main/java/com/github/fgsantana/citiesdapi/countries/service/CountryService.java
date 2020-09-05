package com.github.fgsantana.citiesdapi.countries.service;

import java.util.List;
import java.util.Optional;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import com.github.fgsantana.citiesdapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    CountryRepository repo;

    public CountryService() {
    }

    public Page<Country> getAllCountries(Pageable page) {
        return this.repo.findAll(page);
    }

    public Optional<Country> getCountryById(Long id) {
        return this.repo.findById(id);
    }


}