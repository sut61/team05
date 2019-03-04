package com.sut.se.g05.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class RepairinfoController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository ;
    @Autowired
    private DamageRepository damageRepository ;
    @Autowired
    private RepairinfoRepository repairinfoRepository ;

    @GetMapping("/Repairinfo")
    public Collection <Repairinfo> Repairinfo() {

        return repairinfoRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Driver")
    public Collection<Driver> Driver(){
        return driverRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Damage")
    public Collection<Damage> Damage(){
        return damageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Car")
    public Collection<Car> Car(){
        return carRepository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping("/Repairinfo/{driverId}/{carId}/{damageId}/{phone}")
    public Repairinfo newRepairinfo(Repairinfo newRepairinfo,@PathVariable Long driverId,@PathVariable Long carId,
                                    @PathVariable Long damageId,@PathVariable String phone) {

        Car car = carRepository.findByCarId(carId);
        Driver driver = driverRepository.findByDriverId(driverId);
        Damage damage = damageRepository.findByDamageId(damageId);

        newRepairinfo.setPhone(phone);
        newRepairinfo.setCar(car);
        newRepairinfo.setDamage(damage);
        newRepairinfo.setDriver(driver);

        return  repairinfoRepository.save(newRepairinfo);
    }
}