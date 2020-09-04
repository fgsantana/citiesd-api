package com.github.fgsantana.citiesdapi.countries.repository;

import com.github.fgsantana.citiesdapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}

