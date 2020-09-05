package com.github.fgsantana.citiesdapi.cities.service;


import java.util.Arrays;
import java.util.List;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import com.github.fgsantana.citiesdapi.cities.entities.Distancia;
import com.github.fgsantana.citiesdapi.cities.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    @Autowired
    CityRepository repo;
    private Distancia dis = new Distancia();
    Logger log = LoggerFactory.getLogger(DistanceService.class);



    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        this.log.info("nativePostgresInMiles({}, {})", city1, city2);
        return this.repo.distanceByPoints(city1, city2);
    }

    public Distancia distanceByCubeInMeters(Long city1, Long city2) {
        this.log.info("distanceByCubeInMeters({}, {})", city1, city2);
        List<City> cities = this.repo.findAllById(Arrays.asList(city1, city2));
        Point p1 = (cities.get(0)).getLocation();
        Point p2 = (cities.get(1)).getLocation();
        this.dis.setDistancia(this.repo.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
        this.dis.setUnidade("Metros");
        return this.dis;
    }
}
