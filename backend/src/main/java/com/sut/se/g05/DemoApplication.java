package com.okta.developer.demo;

import java.util.stream.Stream;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200")

@SpringBootApplication
public class DemoApplication {
	@Autowired private	BankempRepository bankempRepository;
	@Autowired private	GenderRepository genderRepository;
	@Autowired private	InformationempRepository informationempRepository;
	@Autowired private	PositionRepository positionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Component
	class DataSetup implements ApplicationRunner{
		@Override
		public void run(ApplicationArguments args) throws NullPointerException{


			Bankemp bankemp1 = new Bankemp("Thai Bank");
			bankempRepository.save(bankemp1);
			Bankemp bankemp2 = new Bankemp("K Bank");
			bankempRepository.save(bankemp2);


			Gender gender1 = new Gender("Male");
			genderRepository.save(gender1);
			Gender gender2 = new Gender("Female");
			genderRepository.save(gender2);


			Position position1 = new Position("Driver");
			positionRepository.save(position1);
			Position position2 = new Position("Manager");
			positionRepository.save(position2);
			Position position3 = new Position("Secretar");
			positionRepository.save(position3);
			Position position4 = new Position("HR");
			positionRepository.save(position4);


			bankempRepository.findAll().forEach(System.out::println);
			genderRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);

		}
	}
}
