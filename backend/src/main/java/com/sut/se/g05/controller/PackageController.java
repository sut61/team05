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
    private EmployeeRepository employeeRepository;
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

    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> getProvince() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/province/{provinceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Province getOneProvince(@PathVariable long provinceId){
        return provinceRepository.findById(provinceId).get();
    }


    @GetMapping(path = "/sender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Sender> getSender() {
        return senderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/sender/{SenderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sender getOneSender(@PathVariable Long senderId){
        return senderRepository.findById(senderId).get();
    }

    @GetMapping(path = "/receiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Receiver> getReceiver() {
        return receiverRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/receiver/{ReceiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receiver getOneReceiver(@PathVariable Long receiverId){
        return receiverRepository.findById(receiverId).get();
    }

    @GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Employee> getEmployee() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/employee/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getOneEmployee(@PathVariable Long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    @PostMapping(path = "/package/{senderName}/{supply}/{receiverName}/{province}/{employeeId}")
    public Package newPackage(Package newPackage, @PathVariable String senderName,
                              @PathVariable String supply, @PathVariable String receiverName,
                              @PathVariable Long province, @PathVariable Long employeeId) {

        Sender sender = senderRepository.findByFirstname(senderName);
        Receiver receiver = receiverRepository.findByFirstname(receiverName);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
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
        Optional<Employee> employee = employeeRepository.findById(id);
        List<Package> packages = new ArrayList<>();
        for (int i = 0; i < tempPackages.size(); i++) {
            if (employee.get() == tempPackages.get(i).getEmployee()) {
                packages.add(tempPackages.get(i));
            }
        }
        return packages;
    }

    @GetMapping(path = "Login/{user}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee packages(
            @PathVariable String user,
            @PathVariable String password
    ) {
        List<Employee> employee = employeeRepository.findAll();
        Employee e = new Employee();
        for (Employee anEmployee : employee) {
            if (user.equals(anEmployee.getUsername()) && password.equals(anEmployee.getPassword())) {
                e = anEmployee;
                return e;
            }
        }
        return null;
    }

}
