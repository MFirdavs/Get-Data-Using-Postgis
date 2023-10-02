package com.example.geoservice.service;

import com.example.geoservice.entity.Geo;
import com.example.geoservice.repository.GeoRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Service;
import org.wololo.geojson.Feature;
import org.wololo.geojson.FeatureCollection;

import java.lang.reflect.Field;
import java.util.*;

import static com.example.geoservice.helper.GeometryHelper.convertJtsGeometryToGeoJson;

@Service
@RequiredArgsConstructor
public class GeoService {

    private final GeoRepository geoRepository;

    public FeatureCollection getAll() {
        List<Geo> geoList = geoRepository.findAll();
        Feature[] features = mapEntityListToFeatures(geoList);
        return new FeatureCollection(features);
    }

    private Feature[] mapEntityListToFeatures(List<Geo> geoList) {
        return geoList
                .stream()
                .map(this::convertEntityToFeature)
                .toArray(Feature[]::new);
    }

    private Feature convertEntityToFeature(Geo entity) {
        Long id = entity.getId();
        org.wololo.geojson.Geometry geometry = convertJtsGeometryToGeoJson(entity.getGeom());

        Map<String, Object> properties = new HashMap<>();

        Arrays.stream(Geo.class.getDeclaredFields())
                .filter(Field::isSynthetic)
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        if (field.getType() != Geometry.class && !field.getName().equals("id") && !field.getName().equals("user")) {
                            properties.put(field.getName(), field.get(entity));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return new Feature(id, geometry, properties);

    }

}
