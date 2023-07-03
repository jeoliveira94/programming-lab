package com.ruemmai.webapps.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }
}
