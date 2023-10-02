package com.example.geoservice.controller;

import com.example.geoservice.entity.Geo;
import com.example.geoservice.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.geojson.Feature;
import org.wololo.geojson.FeatureCollection;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/geo/")
public class GeoController {

    private final GeoService geoService;

//    @GetMapping("all")
//    public FeatureCollection getAllGeo(){
//        return geoService.getAll();
//    }

    @GetMapping("all")
    public ResponseEntity<FeatureCollection> getAll(){
        return new ResponseEntity<>(geoService.getAll() , HttpStatus.OK);
    }

}
