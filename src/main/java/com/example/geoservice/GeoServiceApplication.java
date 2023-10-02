package com.example.geoservice;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoServiceApplication.class, args);
    }

}
