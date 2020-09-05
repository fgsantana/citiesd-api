package com.github.fgsantana.citiesdapi.cities.resource;



import com.github.fgsantana.citiesdapi.cities.dto.Distancia;
import com.github.fgsantana.citiesdapi.cities.exception.InvalidParamException;
import com.github.fgsantana.citiesdapi.cities.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distances")
public class DistanceResource {
    @Autowired
    DistanceService service;




@GetMapping
public Distancia getDistance( @RequestParam String by , @RequestParam String cityX, @RequestParam String cityY) throws InvalidParamException {
    return this.service.distanceByCubeInMeters(by,cityX, cityY);
}




}
