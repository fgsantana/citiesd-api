package com.github.fgsantana.citiesdapi.states.service;

import java.util.List;
import java.util.Optional;

import com.github.fgsantana.citiesdapi.states.entities.State;
import com.github.fgsantana.citiesdapi.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    @Autowired
    StateRepository repo;

    public StateService() {
    }

    public List<State> getAllStates() {
        return this.repo.findAll();
    }

    public Optional<State> getStateById(Long id) {
        return this.repo.findById(id);
    }
}
