package ir.bmi.baam.interviewassignment.bank.service.impl;

import ir.bmi.baam.interviewassignment.bank.exception.BadRequestException;
import ir.bmi.baam.interviewassignment.bank.exception.ElementNotFoundException;
import ir.bmi.baam.interviewassignment.bank.model.City;
import ir.bmi.baam.interviewassignment.bank.repository.CityRepository;
import ir.bmi.baam.interviewassignment.bank.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultCityService implements CityService {
    private final CityRepository cityRepository;

    @Autowired
    DefaultCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository
                .findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Could not find city with ID provided"));
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City createCity(City city) {
        if (city.getId() != null) {
            throw new BadRequestException("The ID must not be provided when creating a new City");
        }

        return cityRepository.save(city);
    }
}

