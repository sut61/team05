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
class RegisterController {
    @Autowired  private BankempRepository bankempRepository;
    @Autowired  private GenderRepository genderRepository;
    @Autowired  private InformationempRepository informationempRepository;
    @Autowired  private PositionRepository positionRepository;

    public RegisterController(  BankempRepository bankempRepository,
                                GenderRepository genderRepository,
                                InformationempRepository informationempRepository,
                                PositionRepository positionRepository){
        this.bankempRepository = bankempRepository;
        this.genderRepository = genderRepository;
        this.informationempRepository = informationempRepository;
        this.positionRepository = positionRepository;

    }

    @GetMapping("/Bankemp")
    public Collection<Bankemp> Bankemp() {

        return bankempRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Informationemp")
    public Collection<Informationemp> Informationemp() {

        return informationempRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Position")
    public Collection<Position> Position() {

        return positionRepository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping(path ="/informationemp/{firstname}/{lastname}/{genderid}/{phone}/{address}/{positionid}/{bankempid}/{banknumber}/{email}/{password}")
    public Informationemp newinformationemp(@PathVariable String firstname,
                                            @PathVariable String lastname,
                                            @PathVariable Long genderid,
                                            @PathVariable String phone,
                                            @PathVariable String address,
                                            @PathVariable Long positionid,
                                            @PathVariable Long bankempid,
                                            @PathVariable String banknumber,
                                            @PathVariable String email,
                                            @PathVariable String password)
            throws ParseException {


        Informationemp i = new Informationemp();
        Bankemp b = bankempRepository.findBybankempid(bankempid);
        Gender g = genderRepository.findBygenderId(genderid);
        Position p = positionRepository.findBypositionid(positionid);
        i.setFirstname(firstname);
        i.setLastname(lastname);
        i.setGender(g);
        i.setPhone(phone);
        i.setAddress(address);
        i.setPosition(p);
        i.setBankemp(b);
        i.setBanknumber(banknumber);
        i.setEmail(email);
        i.setPassword(password);

        informationempRepository.save(i);
        return i;
    }
}