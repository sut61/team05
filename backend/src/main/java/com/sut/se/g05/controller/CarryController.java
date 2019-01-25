package com.sut.se.g05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.entity.Package;
import com.sut.se.g05.repository.*;

import java.text.ParseException;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarryController {
    @Autowired
    private CarryRepository carryRepository;
    @Autowired
    private LinkedRepository linkedRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ReceiverRepository receiverRepository;

    // public CarryController(CarryRepository carryRepository) {
    //     this.carryRepository = carryRepository;
    // }

    @GetMapping("/carrys")
    public Collection<Carry> carry() {
        return carryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/linkeds")
    public Collection<Linked> linked() {
        return linkedRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/packages")
    public Collection<Package> packages() {
        return packageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/provinces")
    public Collection<Province> province() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/receivers")
    public Collection<Receiver> receiver() {
        return receiverRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/carrys/{packageId}/{date}/{carryNumber}/{status}/{receivers}/{nameprovince}")
    public Carry newCarry(
            // @RequestBody Carry newCarry,
            @PathVariable Long packageId, @PathVariable Date date, @PathVariable String carryNumber,
            @PathVariable String status, @PathVariable Long receivers, @PathVariable Long nameprovince

    ) throws ParseException {
        Carry newCarry = new Carry();
        
        Package packages = packageRepository.findByPackageId(packageId);
        Province province = provinceRepository.findByprovinceId(nameprovince);
        Receiver receiver = receiverRepository.findByreceiverId(receivers);

        /*DateFormat newDate = new SimpleDateFormat("ddd mmm dd yyyy"); //
        Date b = newDate.parse(date); //b=date*/

        newCarry.setPackageId(packages);
        newCarry.setDate(date); 
        newCarry.setCarryNumber(carryNumber);
        newCarry.setStatus(status);
        newCarry.setReceiver(receiver);
        newCarry.setProvince(province);
    return carryRepository.save(newCarry);
    
    }
    
    
}