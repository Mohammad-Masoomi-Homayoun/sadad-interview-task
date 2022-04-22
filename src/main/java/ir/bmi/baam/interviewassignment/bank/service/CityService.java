package ir.bmi.baam.interviewassignment.bank.service;

import ir.bmi.baam.interviewassignment.bank.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCityById(Long id);

    City createCity(City city);
}

