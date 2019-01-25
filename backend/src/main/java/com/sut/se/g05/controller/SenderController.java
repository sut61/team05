package com.sut.se.g05.controller;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SenderController {

    @Autowired
    private SenderRepository senderRepository;
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private ProvincesenRepository provincesenRepository;

    @Autowired
    public SenderController(SenderRepository senderRepository, ReceiverRepository receiverRepository,
                            GenderRepository genderRepository, ProvinceRepository provinceRepository,
                            LinkRepository linkRepository, ProvincesenRepository provincesenRepository){
        this.senderRepository = senderRepository;
        this.receiverRepository = receiverRepository;
        this.genderRepository = genderRepository;
        this.provinceRepository = provinceRepository;
        this.linkRepository = linkRepository;
        this.provincesenRepository = provincesenRepository;
    }

    //sender
    @GetMapping(path = "/Sender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Sender> getSender() {
        return senderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Sender/{SenderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sender getOneSender(@PathVariable Long senderId){
        return senderRepository.findById(senderId).get();
    }

    //receiver
    @GetMapping(path = "/Receiver", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Receiver> getReceiver() {
        return receiverRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Receiver/{ReceiverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receiver getOneReceiver(@PathVariable Long receiverId){
        return receiverRepository.findById(receiverId).get();
    }

    //gender
    @GetMapping(path = "/Gender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Gender> getGender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }


    //province
    @GetMapping(path = "/Province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> getProvince() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }



    //provincesen
    @GetMapping(path = "/Provincesen", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Provincesen> getProvincesen() {
        return provincesenRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/provincesen/{provincesenId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Provincesen getOneProvincesen(@PathVariable Long provincesenId){
        return provincesenRepository.findById(provincesenId).get();
    }

    //link
    @GetMapping(path = "/Link", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Link> getLink() {
        return linkRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/link/{linkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Link getOneLink(@PathVariable Long linkId){
        return linkRepository.findById(linkId).get();
    }


    @PostMapping(path ="/sender/{firstnamesenInput}/{lastnamesenInput}/{genderNameSelect}/{addresssenInput}"+
            "/{provincesenNameSelect}/{postcodesenInput}/{phonesenInput}/{emailInput}/{passwordInput}")
    public Sender newSender(@RequestBody Sender sender,@PathVariable String firstnamesenInput,
                            @PathVariable String lastnamesenInput,@PathVariable String genderNameSelect,
                            @PathVariable String addresssenInput,@PathVariable String provincesenNameSelect,
                            @PathVariable String postcodesenInput,@PathVariable String phonesenInput,
                            @PathVariable String emailInput, @PathVariable String passwordInput
    ) {
        Sender s = new Sender();
        Gender gender = genderRepository.findBygender(genderNameSelect);
        System.out.print(gender);
        Provincesen provincesen = provincesenRepository.findByprovincesen(provincesenNameSelect);
        System.out.print(provincesen);

        s.setFirstname(firstnamesenInput);
        s.setLastname(lastnamesenInput);
        s.setGender(gender);
        s.setAddress(addresssenInput);
        s.setProvincesen(provincesen);
        s.setPostcode(postcodesenInput);
        s.setPhone(phonesenInput);
        s.setEmail(emailInput);
        s.setPassword(passwordInput);
        return senderRepository.save(s);
    }

    @PostMapping(path ="/receiver/{firstnamerecInput}/{lastnamerecInput}/{addressrecInput}" +
            "/{provinceNameSelect}/{postcoderecInput}/{phonerecInput}")
    public Receiver newReceiver(@RequestBody Receiver receiver,@PathVariable String firstnamerecInput,
                                @PathVariable String lastnamerecInput,
                                @PathVariable String addressrecInput,@PathVariable String provinceNameSelect,
                                @PathVariable String postcoderecInput,@PathVariable String phonerecInput
    ) {
        Receiver r = new Receiver();
        Province province = provinceRepository.findByprovince(provinceNameSelect);
        System.out.print(province);

        r.setFirstname(firstnamerecInput);
        r.setLastname(lastnamerecInput);
        r.setAddress(addressrecInput);
        r.setProvince(province);
        r.setPostcode(postcoderecInput);
        r.setPhone(phonerecInput);
        return receiverRepository.save(r);
    }
}
