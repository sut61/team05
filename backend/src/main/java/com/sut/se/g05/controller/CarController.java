package com.sut.se.g05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import java.text.ParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarBrandRepository carBrandRepository;
    @Autowired
    private CarInsuranceRepository carInsuranceRepository;
    @Autowired
    private ProvinceRepository provinceRepository;


    @GetMapping("/cars")
    public Collection<Car> car() {
        return carRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/carBrands")
    public Collection<CarBrand> carBrand() {
        return carBrandRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/carInsurances")
    public Collection<CarInsurance> carInsurance() {
        return carInsuranceRepository.findAll().stream().collect(Collectors.toList());
    }

    //provinces
    // @GetMapping("/provinces")
    // public Collection<Province> province() {
    //     return provinceRepository.findAll().stream().collect(Collectors.toList());
    // }


    @PostMapping("/cars/{nameCarBrand}/{licenseplate}/{nameprovince}/{namecompany}")
    public Car newCar(
            @PathVariable String nameCarBrand, @PathVariable String licenseplate, 
            @PathVariable String nameprovince, @PathVariable String namecompany

    ) throws ParseException {
        Car newCar = new Car();

        CarBrand b = carBrandRepository.findByBrand(nameCarBrand);
        Province province = provinceRepository.findByprovince(nameprovince);
        CarInsurance insurance = carInsuranceRepository.findByCompany(namecompany);
        
        newCar.setBrand(b);
        newCar.setLicenseplate(licenseplate);
        newCar.setProvince(province);
        newCar.setCompany(insurance);
        return carRepository.save(newCar);

    }


}