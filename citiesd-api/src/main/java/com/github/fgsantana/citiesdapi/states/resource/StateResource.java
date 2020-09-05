package com.github.fgsantana.citiesdapi.states.resource;

import java.util.List;
import java.util.Optional;

import com.github.fgsantana.citiesdapi.states.entities.State;
import com.github.fgsantana.citiesdapi.states.exception.StateNotFoundException;
import com.github.fgsantana.citiesdapi.states.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/states")
public class StateResource {
    @Autowired
    StateService service;



    @GetMapping
    public List<State> getStates() {
        return this.service.getStates();
    }

    @GetMapping("/{state}")
    public State getState(@PathVariable("state") String state) throws StateNotFoundException {

        return service.getByNameOrId(state);
    }
}
