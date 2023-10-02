package com.example.geoservice.repository;

import com.example.geoservice.entity.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoRepository extends JpaRepository<Geo , Long> {


}
