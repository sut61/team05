package com.sut.se.g05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import com.sut.se.g05.entity.*;
import com.sut.se.g05.entity.Carcontrol;
import com.sut.se.g05.repository.*;

import java.text.ParseException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarcontrolController {
    @Autowired
    private CarcontrolRepository carcontrolRepository;
    @Autowired
    private CarInformationRepository carInformationRepository;
    @Autowired
    private CarStatusRepository carStatusRepository;
    @Autowired
    private ProvinceRepository provinceRepository;


    @GetMapping("/carcontrols")
    public Collection<Carcontrol> carcontrol() {
        return carcontrolRepository.findAll().stream().collect(Collectors.toList());
    }

    // @GetMapping("/carInformations")
    // public Collection<CarInformation> carInformation() {
    //     return carInformationRepository.findAll().stream().collect(Collectors.toList());
    // }

    @GetMapping("/carStatuss")
    public Collection<CarStatus> carStatus() {
        return carStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    // @GetMapping("/provinces")
    // public Collection<Province> province() {
    //     return provinceRepository.findAll().stream().collect(Collectors.toList());
    // }


    @PostMapping("/carcontrols/{info}/{time}/{annotation}/{stype}/{nameprovince}")
    public Carcontrol newCarcontrol(
            @PathVariable Long info, @PathVariable Date time, @PathVariable String annotation, 
            @PathVariable String stype, @PathVariable Long nameprovince

    ) throws ParseException {
        Carcontrol newCarcontrol = new Carcontrol();

        CarInformation carInfo = carInformationRepository.findByCarInformationId(info);
        CarStatus cStatus = carStatusRepository.findByStatusType(stype);
        Province province = provinceRepository.findByprovinceId(nameprovince);
          
        newCarcontrol.setInformation(carInfo);
        newCarcontrol.setTime(time);
        newCarcontrol.setStatusType(cStatus);
        newCarcontrol.setProvince(province);
        newCarcontrol.setAnnotation(annotation);
        return carcontrolRepository.save(newCarcontrol);
        }
}