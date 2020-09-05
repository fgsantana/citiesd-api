package com.github.fgsantana.citiesdapi.cities.service;


import com.github.fgsantana.citiesdapi.cities.dto.Distancia;
import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.exception.CityNotFoundException;
import com.github.fgsantana.citiesdapi.cities.exception.InvalidParamException;
import com.github.fgsantana.citiesdapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {
    @Autowired
    CityRepository repo;


    /*public Double distanceByPointsInMiles(final String city1, final String city2) {
        this.log.info("nativePostgresInMiles({}, {})", city1, city2);
        return (this.repo.distanceByPoints(city1, city2));
    }
    */

    public Distancia distanceByCubeInMeters(String by, String cityX, String cityY) throws InvalidParamException, CityNotFoundException {
        if (by.equals("id")) {
            return distanceByCubeInMetersByIds(Long.parseLong(cityX), Long.parseLong(cityY));
        } else if (by.equals("name")) {
            return distanceByCubeInMeterByName(cityX, cityY);
        } else {
            throw new InvalidParamException();
        }
    }


    public Distancia distanceByCubeInMetersByIds(Long cityX, Long cityY) throws CityNotFoundException {
        List<City> cities = this.repo.findAllById(Arrays.asList(cityX, cityY));
        if (cities.size() < 2) {
            throw new CityNotFoundException();
        }
        City city1 = cities.get(0);
        City city2 = cities.get(1);
        Point p1 = city1.getLocation();
        Point p2 = city2.getLocation();
        String dist = String.format("%.3f", (repo.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY()) / 1000));
        Double distance = Double.parseDouble(dist.replace(",", "."));

        return new Distancia(city1.getName(), city2.getName(), distance, "KM");
    }

    public Distancia distanceByCubeInMeterByName(String cityX, String cityY) throws CityNotFoundException {
        List<City> cities = this.repo.findTwoCities(cityX, cityY);
        if (cities.size() < 2) {
            throw new CityNotFoundException();
        }

        City city1 = cities.get(0);
        City city2 = cities.get(1);
        Point p1 = city1.getLocation();
        Point p2 = city2.getLocation();
        String dist = String.format("%.3f", (this.repo.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY()) / 1000));
        Double distance = Double.parseDouble(dist.replace(",", "."));

        return new Distancia(city1.getName(), city2.getName(), distance, "KM");


    }
}
