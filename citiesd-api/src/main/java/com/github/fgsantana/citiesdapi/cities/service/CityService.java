package com.github.fgsantana.citiesdapi.cities.service;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.exception.CityNotFoundException;
import com.github.fgsantana.citiesdapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    CityRepository repo;
    List<City> list = new ArrayList<City>();

    public Page<City> getCities(Pageable page) {
        return repo.findAll(page);
    }


    public List<City> getByNameOrId(String city) throws CityNotFoundException {

        if (isLongNumber(city)) {
            Long id = Long.parseLong(city);
            return getById(id);
        } else {
            return getByName(city);
        }


    }




    public List<City> getById(Long id) throws CityNotFoundException {

        City fndCity = repo.findById(id).orElseThrow(() -> new CityNotFoundException());

        return Collections.singletonList(fndCity);
    }



    public List<City> getByName(String name) throws CityNotFoundException {
        list = repo.findByName(name);
        if (list.isEmpty()) {
            throw new CityNotFoundException();
        }
        return list;

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
