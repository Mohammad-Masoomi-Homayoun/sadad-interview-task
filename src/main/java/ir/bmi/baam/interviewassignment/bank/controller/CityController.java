package ir.bmi.baam.interviewassignment.bank.controller;

import ir.bmi.baam.interviewassignment.bank.model.City;
import ir.bmi.baam.interviewassignment.bank.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }
}
