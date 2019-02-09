package com.sut.se.g05.controller;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import java.text.ParseException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class SalaryController {
    @Autowired
    private BankempRepository bankempRepository;
    @Autowired
    private DeduetionRepository deduetionRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private SalaryRepository salaryRepository;


    @GetMapping("/Deduetion")
    public Collection<Deduetion> Deduetion() {

        return deduetionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Salary")
    public Collection<Salary> Salary() {

        return salaryRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/salary/{name}/{positionid}/{bankempid}/{banknumber}/{deduetionid}/{balance}")
    public Salary newsalary(@PathVariable String name, @PathVariable Long positionid, @PathVariable Long bankempid,
            @PathVariable String banknumber, @PathVariable Long deduetionid, @PathVariable Integer balance)
            throws ParseException {

        Salary s = new Salary();
        Bankemp b = bankempRepository.findBybankempid(bankempid);
        Deduetion d = deduetionRepository.findBydeduetionid(deduetionid);
        Position p = positionRepository.findBypositionid(positionid);
        s.setName(name);
        s.setPosition(p);
        s.setBankemp(b);
        s.setBanknumber(banknumber);
        s.setDeduetion(d);
        s.setBalance(balance);

        salaryRepository.save(s);
        return s;
    }
}
