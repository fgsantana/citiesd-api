package com.github.fgsantana.citiesdapi.cities.repository;

import com.github.fgsantana.citiesdapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query(
            value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance",
            nativeQuery = true
    )
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    @Query(
            value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance",
            nativeQuery = true
    )
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

    @Query(
            value = "SELECT * FROM cidade WHERE nome=?1",
            nativeQuery = true
    )
    List<City> findCityByName(String name);
}
