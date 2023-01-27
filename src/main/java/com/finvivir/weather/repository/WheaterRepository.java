package com.finvivir.weather.repository;

import com.finvivir.weather.models.Wheater;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WheaterRepository extends JpaRepository<Wheater, Integer> {
    List<Wheater> findAllBy(Pageable pageable);
    @Query(value = "select * from wheater where search_city = ?1 limit 1;", nativeQuery = true)
    Optional<Wheater> serviceDown(String city);
}
