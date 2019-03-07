package com.sut.se.g05;
import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class CarInformationTest{

	@Autowired
	private CarInformationRepository carInformationRepository;
	@Autowired
	private TestEntityManager entityManager;
	private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	// @Test
	// public void contextLoads() {
	// ////////////////////////////////กรณีที่ถูก///////////////////////////////////
	// 	CarInformation c = new CarInformation();
    //     c.setName("Suranaree");
    //     c.setAddress("Suranaree 30000");
    //     c.setTelephone("0988313467");
    //     c.setAge(20);

    //     try {
    //         entityManager.persist(c);
    //         entityManager.flush();

           
    //     }catch(javax.validation.ConstraintViolationException e){
    //         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
    //         assertEquals(violations.size(), 1);
    //     }

	// }

	@Test
	public void testNameNull() {
	CarInformation c = new CarInformation();
        c.setName(null);
        c.setAddress("Suranaree 30000");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void testNamemax() {
	CarInformation c = new CarInformation();
        c.setName("ttttttttttttttttttttttttttttttttttttttttttttttt");
        c.setAddress("Suranaree 30000");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}
	@Test
	public void testNamemin() {
	CarInformation c = new CarInformation();
        c.setName("eiei");
        c.setAddress("Suranaree 30000");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	// @Test
	// public void testNamenopetter() {
	// CarInformation c = new CarInformation();
    //     c.setName("tanz benjamas1996");
    //     c.setAddress("Suranaree 30000");
    //     c.setTelephone("0988313467");
    //     c.setAge(20);

    //     try {
    //         entityManager.persist(c);
    //         entityManager.flush();

	// 		fail("Should not pass to this line");
    //     }catch(javax.validation.ConstraintViolationException e){
    //         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
    //         assertEquals(violations.size(), 1);
    //     }

	// }

	////////////////////////////////กรณีที่ถูก/////////////////////////////////////
	@Test
	public void testTelephone() {
	CarInformation c = new CarInformation();
        c.setName("เบญจมาส มัจฉา");
        c.setAddress("Suranaree 30000");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}
	@Test
	public void testTelephonenopetternull() {
	CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("Suranaree 30000");
        c.setTelephone(null);
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void testTelephonenopetterlong() {
	CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("Suranaree 30000");
        c.setTelephone("098875242563596259");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void testaddressNull() {
	CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress(null);
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

	}

	@Test
	public void testAgeNull() {
	CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("Suranaree");
        c.setTelephone("0988313467");
        c.setAge(null);

        try {
            entityManager.persist(c);
            entityManager.flush();

			fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }
    
    @Test
    public void testidcardnumbsrNull() { 
        CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("suranaree");
        c.setIdcardnumber(null);
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test
    public void testidcardnumbsrlong() { 
        CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("suranaree");
        c.setIdcardnumber("131990052131111");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testidcardnumbsrshort() { 
        CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("suranaree");
        c.setIdcardnumber("13199005");
        c.setTelephone("0988313467");
        c.setAge(20);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch(javax.validation.ConstraintViolationException e){
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testidcardnumberUnique() { 
        CarInformation c = new CarInformation();
        c.setName("tttttttt");
        c.setAddress("suranaree");
        c.setIdcardnumber("1319900521311");
        c.setTelephone("0988313467");
        c.setAge(20);
        entityManager.flush();

        CarInformation c1 = new CarInformation();
        c1.setName("tanzzz");
        c1.setAddress("suranaree");
        c1.setIdcardnumber("1319900521311");
        c1.setTelephone("0878713424");
        c1.setAge(20);

        try{
            entityManager.persist(c1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM testidcardnumberUnique ======================");
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
