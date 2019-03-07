package com.sut.se.g05;
import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import java.util.Date;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigurationPackage
@DataJpaTest
public class CarcontrolTest {

	@Autowired
	private CarcontrolRepository carcontrolRepository;
	@Autowired
	private TestEntityManager entityManager;
	private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}

	@Test
	public void carcontrol() {

		Carcontrol car = new Carcontrol();
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaa");
		car.setAnnotation("helloworld");
		try {
            entityManager.persist(car);
            entityManager.flush();

			
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	 @Test
	public void carconmin() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("a");
		car.setAnnotation("helloworld");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	
	@Test
	public void carconnull() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol(null);
		car.setAnnotation("helloworld");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}


	@Test
	public void setTimeNull() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(null);
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaa");
		car.setAnnotation("helloworld");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void timeoutnull() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(null);
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaaa");
		car.setAnnotation("helloworld");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void Annotationnull() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaa");
		car.setAnnotation(null);
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void carconmax() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		car.setAnnotation("aaaaaaaa");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void CarconNotPattern() {

		Carcontrol car = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("ฟหกฟหกดฟหด");
		car.setAnnotation("aaaaa");
		try {
            entityManager.persist(car);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
		}
	}
	

	@Test(expected = javax.persistence.PersistenceException.class)
	public void testCarconUnique() { 
		Carcontrol car = new Carcontrol();
		Carcontrol car1 = new Carcontrol();
		
		car.setTime(new Date());
		car.setTimeout(new Date());
		car.setVotepoint(1);
		car.setIdcarcontrol("aaaaa");
		car.setAnnotation("aaaaa");
		entityManager.persist(car);
		entityManager.flush();

		car1.setTime(new Date());
		car1.setTimeout(new Date());
		car1.setVotepoint(2);
		car1.setIdcarcontrol("aaaaa");
		car1.setAnnotation("asdasfd");
		entityManager.persist(car1);


		System.out.println();
		System.out.println("----------> BeUnique <--------------------");
		System.out.println();
		System.out.println();
  
		entityManager.flush();
		fail("Should not pass to this line");
	}
}

