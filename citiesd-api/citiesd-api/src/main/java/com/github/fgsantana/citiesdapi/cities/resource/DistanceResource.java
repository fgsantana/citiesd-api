package com.github.fgsantana.citiesdapi.cities.resource;



import com.github.fgsantana.citiesdapi.cities.entities.Distancia;
import com.github.fgsantana.citiesdapi.cities.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/distances"})
public class DistanceResource {
    @Autowired
    DistanceService service;

    public DistanceResource() {
    }

    @GetMapping
    public Distancia getDistanceByIds(@RequestParam Long cidade1, @RequestParam Long cidade2) {
        return this.service.distanceByCubeInMeters(cidade1, cidade2);
    }


}
