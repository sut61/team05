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
		car.setAnnotation("a");
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
		car.setAnnotation("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
	public void carcontrolnull() {

		Carcontrol car = new Carcontrol();
		car.setTime(new Date());
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

}

