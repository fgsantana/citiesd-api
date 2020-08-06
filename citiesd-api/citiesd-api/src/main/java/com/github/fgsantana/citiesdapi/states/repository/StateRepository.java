package com.github.fgsantana.citiesdapi.states.repository;

import com.github.fgsantana.citiesdapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
