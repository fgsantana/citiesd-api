package com.github.fgsantana.citiesdapi.cities.service;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<City> findByNameOrId(String city) {


        try {
            Long id = Long.parseLong(city);
            List<City> list = new ArrayList<City>();
            Optional<City> op = repo.findById(id);
            if (op.isPresent()) {
                list.add(op.get());
            }
            return list;

        } catch (NumberFormatException e) {

            return repo.findCityByName(city);
        }
    }
}
