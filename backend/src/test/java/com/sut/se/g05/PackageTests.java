package com.sut.se.g05;

import com.sut.se.g05.entity.Package;
import com.sut.se.g05.repository.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigurationPackage
//@SpringBootConfiguration
@DataJpaTest
public class PackageTests {

	@Autowired
	private SenderRepository senderRepository;
	@Autowired
	private ReceiverRepository receiverRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private PackageRepository packageRepository;
	@Autowired
	private InformationempRepository informationempRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testSetPackage() {
		Package p = new Package();
		p.setSupply("Geforce GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testNotnull() {
		Package p = new Package();
		p.setSupply(null);
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("=====Error Null=====");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testSizeInputTooShort() {
		Package p = new Package();
		p.setSupply("a1");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("=====Error Size Short=====");
			System.out.println(e);
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testSizeInputTooLong() {
		Package p = new Package();
		p.setSupply("a1a12a3a4a5a6a7a8a9a11a12");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("=====Error Size Long=====");
			System.out.println(e);
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testSupplyInput() {
		Package p = new Package();
		p.setSupply("@assa");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("=====Error Pattern=====");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

}

