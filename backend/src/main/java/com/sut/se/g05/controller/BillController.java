package com.sut.se.g05.controller;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.BillRepository;
import com.sut.se.g05.repository.CarryRepository;
import com.sut.se.g05.repository.InformationempRepository;
import com.sut.se.g05.repository.PaidStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {
    @Autowired
    private CarryRepository carryRepository;
    @Autowired
    private PaidStatusRepository paidStatusRepository;
    @Autowired
    InformationempRepository informationempRepository;
    @Autowired
    private BillRepository billRepository;

    @GetMapping(path = "/status")
    public Collection<PaidStatus> getStatus() {
        return paidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/bill/{employee}/{carryNum}/{recName}/{phone}/{status}")
    public Bill newBill(Bill newBill, @PathVariable Long employee, @PathVariable Long carryNum, @PathVariable String recName,
                        @PathVariable String phone, @PathVariable Long status){

        Optional<Informationemp> e = informationempRepository.findById(employee);
        Optional<Carry> c = carryRepository.findById(carryNum);
        Optional<PaidStatus> s = paidStatusRepository.findById(status);

        newBill.setRecName(recName);
        newBill.setPhone(phone);
        newBill.setPaidDate(new Date());
        newBill.setPaidTime(new Timestamp(System.currentTimeMillis()));
        newBill.setCarry(c.get());
        newBill.setEmployee(e.get());
        newBill.setStatus(s.get());

        return billRepository.save(newBill);
    }
}
