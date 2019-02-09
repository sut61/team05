package com.sut.se.g05.controller;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.entity.Package;
import com.sut.se.g05.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private InformationempRepository informationempRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping(path = "/package", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Package> packages() {
        return packageRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/package/{packid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Package getOnePackage(@PathVariable Long packid){
        return packageRepository.findById(packid).get();
    }


    @GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Informationemp> getEmployee() {
        return informationempRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Informationemp getOneEmployee(@PathVariable Long employeeId){
        return informationempRepository.findById(employeeId).get();
    }

    @PostMapping(path = "/package/{senderName}/{supply}/{receiverName}/{province}/{employeeId}")
    public Package newPackage(Package newPackage, @PathVariable String senderName,
                              @PathVariable String supply, @PathVariable String receiverName,
                              @PathVariable Long province, @PathVariable Long employeeId) {

        Sender sender = senderRepository.findByfirstname(senderName);
        Receiver receiver = receiverRepository.findByfirstname(receiverName);
        Optional<Informationemp> employee = informationempRepository.findById(employeeId);
        Optional<Province> provinces = provinceRepository.findById(province);

        newPackage.setSupply(supply);
        newPackage.setSender(sender);
        newPackage.setReceiver(receiver);
        newPackage.setProvince(provinces.get());
        newPackage.setEmployee(employee.get());
        newPackage.setRegDate(new Date());
        newPackage.setRegTime(new Timestamp(System.currentTimeMillis()));

        return packageRepository.save(newPackage);
    }

    @GetMapping(path = "package/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Package> packages(@PathVariable Long id) {
        List<Package> tempPackages = packageRepository.findAll();
        Optional<Informationemp> employee = informationempRepository.findById(id);
        List<Package> packages = new ArrayList<>();
        for (int i = 0; i < tempPackages.size(); i++) {
            if (employee.get() == tempPackages.get(i).getEmployee()) {
                packages.add(tempPackages.get(i));
            }
        }
        return packages;
    }

    @GetMapping(path = "Login/{user}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Informationemp packages(
            @PathVariable String user,
            @PathVariable String password
    ) {
        List<Informationemp> employee = informationempRepository.findAll();
        Informationemp e = new Informationemp();
        for (Informationemp anEmployee : employee) {
            if (user.equals(anEmployee.getEmail()) && password.equals(anEmployee.getPassword())) {
                e = anEmployee;
                return e;
            }
        }
        return null;
    }

}