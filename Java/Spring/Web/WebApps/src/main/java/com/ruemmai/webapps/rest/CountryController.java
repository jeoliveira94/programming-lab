package com.ruemmai.webapps.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("Spain", 47);
        return List.of(country1, country2);
    }
}
