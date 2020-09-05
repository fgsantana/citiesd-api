package com.github.fgsantana.citiesdapi.countries.repository;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query(
            value = "SELECT * FROM pais WHERE unaccent(nome) ILIKE unaccent(?1) OR unaccent(nome_pt) unaccent(ILIKE ?1)",
            nativeQuery = true
    )
    Optional<Country> findByName(String name);
}

