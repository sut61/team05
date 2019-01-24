package com.sut.se.g05.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.sut.se.g05.entity.Car;
import com.sut.se.g05.entity.Damage;
import com.sut.se.g05.entity.Driver;
import com.sut.se.g05.entity.Repairinfo;
import com.sut.se.g05.repository.*;
import java.util.Collection;
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
    public Repairinfo newRepairinfo(@RequestBody Repairinfo newRepairinfo,@PathVariable long driverId,@PathVariable long carId,@PathVariable long damageId,@PathVariable String phone) {

        Car car = carRepository.findById(carId);
        Driver driver = driverRepository.findById(driverId);
        Damage damage = damageRepository.findById(damageId);

        newRepairinfo.setPhone(phone);
        newRepairinfo.setCar(car);
        newRepairinfo.setDamage(damage);
        newRepairinfo.setDriver(driver);

        return  repairinfoRepository.save(newRepairinfo);
    }
}
