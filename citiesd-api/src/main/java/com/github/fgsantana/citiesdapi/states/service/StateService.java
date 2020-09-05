package com.github.fgsantana.citiesdapi.states.service;

import java.util.List;

import com.github.fgsantana.citiesdapi.states.entities.State;
import com.github.fgsantana.citiesdapi.states.exception.StateNotFoundException;
import com.github.fgsantana.citiesdapi.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    StateRepository repo;



    public List<State> getStates() {
        return this.repo.findAll();
    }

    public State getByNameOrId(String state) throws StateNotFoundException {

        if (isLongNumber(state)) {
            Long id = Long.parseLong(state);

            return repo.findById(id).orElseThrow(() -> new StateNotFoundException());
        }


        return  repo.findByName(state).orElseThrow(() -> new StateNotFoundException());


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