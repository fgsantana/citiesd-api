package com.github.fgsantana.citiesdapi.states.repository;

import com.github.fgsantana.citiesdapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {
    @Query(
            value = "SELECT * FROM estado WHERE unaccent(nome) ILIKE unaccent(?1)",
            nativeQuery = true
    )
    Optional<State> findByName(String name);
}
