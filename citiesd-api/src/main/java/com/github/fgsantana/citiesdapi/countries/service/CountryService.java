package com.github.fgsantana.citiesdapi.countries.service;



import com.github.fgsantana.citiesdapi.countries.entities.Country;
import com.github.fgsantana.citiesdapi.countries.exception.CountryNotFoundException;
import com.github.fgsantana.citiesdapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountryRepository repo;


    public Page<Country> getCountries(Pageable page) {
        return this.repo.findAll(page);
    }


    public Country getByNameOrId(String country) throws CountryNotFoundException {

        if (isLongNumber(country)) {
            Long id = Long.parseLong(country);

            return repo.findById(id).orElseThrow(() -> new CountryNotFoundException());
        }

        return  repo.findByName(country).orElseThrow(() -> new CountryNotFoundException());


    }

    public boolean isLongNumber(String string) {

        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
