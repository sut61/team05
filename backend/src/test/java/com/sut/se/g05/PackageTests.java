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

import javax.persistence.PersistenceException;
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
		p.setSupply("GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testSupplyNotnull() {
		Package p = new Package();
		p.setSupply(null);
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testSupplySizeTooShort() {
		Package p = new Package();
		p.setSupply("a1");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testSupplySizeTooLong() {
		Package p = new Package();
		p.setSupply("a1a12a3a4a5a6a7a8a9a11a12");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testSupplyPattern() {
		Package p = new Package();
		p.setSupply("@assa");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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

	@Test
	public void testPackNumNotnull() {
		Package p = new Package();
		p.setSupply("GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum(null);
		p.setPrice((long)16900);

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
	public void testPackNumUnique() {
		Package p1 = new Package();
		p1.setSupply("GTX1080");
		p1.setRegDate(new Date());
		p1.setRegTime(new Timestamp(System.currentTimeMillis()));
		p1.setPackNum("b5825752");
		p1.setPrice((long)16900);

		entityManager.persist(p1);
		entityManager.flush();

		Package p2 = new Package();
		p2.setSupply("GTX1080");
		p2.setRegDate(new Date());
		p2.setRegTime(new Timestamp(System.currentTimeMillis()));
		p2.setPackNum("b5825752");
		p2.setPrice((long)16900);

		try {
			entityManager.persist(p2);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(PersistenceException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("=====Error PackNUM Unique=====");
		}
	}

	@Test
	public void testDateNotnull() {
		Package p = new Package();
		p.setSupply("GTX1080");
		p.setRegDate(null);
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testTimeNotnull() {
		Package p = new Package();
		p.setSupply("GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(null);
		p.setPackNum("b5825752");
		p.setPrice((long)16900);

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
	public void testPriceNotnull() {
		Package p = new Package();
		p.setSupply("GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice(null);

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
	public void testPriceIsPositive() {
		Package p = new Package();
		p.setSupply("GTX1080");
		p.setRegDate(new Date());
		p.setRegTime(new Timestamp(System.currentTimeMillis()));
		p.setPackNum("b5825752");
		p.setPrice((long)-500);

		packageRepository.save(p);

		try {
			entityManager.persist(p);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("=====Error Price Positive=====");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
}

