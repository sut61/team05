package com.sut.se.g05;

import com.sut.se.g05.entity.Repairinfo;
import com.sut.se.g05.repository.RepairinfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigurationPackage
public class RepairinfoTests {

	@Autowired
	private RepairinfoRepository repairinfoRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void TestSuccess() {
		Repairinfo r = new Repairinfo();
		r.setPhone("0123456789");

		try{
			entityManager.persist(r);
			entityManager.flush();

			//fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("================ From TestSuccess =================");
			System.out.println(e);
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneNull() {
		Repairinfo r = new Repairinfo();
		r.setPhone(null);

		try{
			entityManager.persist(r);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneNull =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneTooLong() {
		Repairinfo r = new Repairinfo();
		r.setPhone("01234567890123456789");

		try{
			entityManager.persist(r);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneTooLong =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneTooShort() {
		Repairinfo r = new Repairinfo();
		r.setPhone("01");

		try{
			entityManager.persist(r);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneTooShort =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneWrongPattern() {
		Repairinfo r = new Repairinfo();
		r.setPhone("abAB1234กข");

		try{
			entityManager.persist(r);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneWrongPattern =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestRepairinfoUnique() {
		Repairinfo r1 = new Repairinfo();
		r1.setPhone("0123456789");

		entityManager.persist(r1);
		entityManager.flush();

		Repairinfo r2 = new Repairinfo();
		r2.setPhone("0123456789");

		try{
			entityManager.persist(r2);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("================ From TestRepairinfoUnique ======================");
			e.printStackTrace();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
		catch (javax.persistence.PersistenceException e){
			System.out.println("==================================================================");
			e.printStackTrace();
		}
	}
}

