package com.example.geoservice.controller;

import com.example.geoservice.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.geojson.FeatureCollection;


@RestController
@RequiredArgsConstructor
@RequestMapping("/geo/")
public class GeoController {

    private final GeoService geoService;

    @GetMapping("all")
    public ResponseEntity<FeatureCollection> getAll(){
        return new ResponseEntity<>(geoService.getAll() , HttpStatus.OK);
    }

}
