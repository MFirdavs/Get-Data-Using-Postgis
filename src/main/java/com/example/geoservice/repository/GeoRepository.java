package com.example.geoservice.repository;

import com.example.geoservice.entity.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeoRepository extends JpaRepository<Geo , Long> {


}
