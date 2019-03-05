package com.sut.se.g05.controller;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BounceController {

    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private LinksenRepository linksenRepository;
    @Autowired
    private BounceRepository bounceRepository;
    @Autowired
    private TypeproductRepository typeproductRepository;

    @Autowired
    public BounceController(SenderRepository senderRepository, ReceiverRepository receiverRepository,
                            ProvinceRepository provinceRepository, LinkRepository linkRepository,
                            BounceRepository bounceRepository,
                            LinksenRepository linksenRepository, TypeproductRepository typeproductRepository){
        this.senderRepository = senderRepository;
        this.receiverRepository = receiverRepository;
        this.bounceRepository = bounceRepository;
        this.provinceRepository = provinceRepository;
        this.linkRepository = linkRepository;
        this.linksenRepository = linksenRepository;
        this.typeproductRepository = typeproductRepository;
    }

    //sender
    @GetMapping(path = "/sender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Sender> getSender() {
        return senderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/sender/{senderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sender getOneSender(@PathVariable Long senderId){
        return senderRepository.findById(senderId).get();
    }

    //receiver
    @GetMapping(path = "/receiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Receiver> getReceiver() {
        return receiverRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/receiver/{receiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receiver getOneReceiver(@PathVariable Long receiverId){
        return receiverRepository.findById(receiverId).get();
    }

    //province
    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> getProvince() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/province/{provinceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Province getOneProvince(@PathVariable long provinceId){
        return provinceRepository.findById(provinceId).get();
    }

    //linksen
    @GetMapping(path = "/linksen", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Linksen> getLinksen() {
        return linksenRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/linksen/{linksenId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Linksen getOneLinksen(@PathVariable Long linksenId){
        return linksenRepository.findById(linksenId).get();
    }

    //typeproduct
    @GetMapping(path = "/typeproduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Typeproduct> getTypeproduct() {
        return typeproductRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/typeproduct/{typeproductId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Typeproduct getOneTypeproduct(@PathVariable Long typeproductId){
        return typeproductRepository.findById(typeproductId).get();
    }

    //bounce
    @GetMapping(path = "/bounce", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Bounce> getBounce() {
        return bounceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/bounce/{bounceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Bounce getOneBounce(@PathVariable Long bounceId){
        return bounceRepository.findById(bounceId).get();
    }


    @PostMapping(path ="/bounce/{senderSelect}/{provincesenSelect}/{receiverSelect}/{provinceSelect}/{reasonInput}/{typeproductNameSelect}")
    public Bounce newBounce(@RequestBody Bounce bounce, @PathVariable String senderSelect, @PathVariable String provincesenSelect,
                            @PathVariable String receiverSelect, @PathVariable String provinceSelect,
                            @PathVariable String reasonInput,
                            @PathVariable String typeproductNameSelect
    ) {
        Bounce a = new Bounce();
        Typeproduct t = typeproductRepository.findBytypeproduct(typeproductNameSelect);
        Sender s = senderRepository.findByfirstname(senderSelect);
        Receiver r = receiverRepository.findByfirstname(receiverSelect);
        Province p = provinceRepository.findByprovince(provinceSelect);
        Province ps = provinceRepository.findByprovince(provincesenSelect);

        a.setSender(s);
        a.setProvince(ps);
        a.setReceiver(r);
        a.setProvince(p);
        a.setReason(reasonInput);
        a.setTypeproduct(t);
        return bounceRepository.save(a);
    }

}


