package com.sut.se.g05;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarryTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarryRepository carryRepository;

    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	

	@Test
	public void testSuccess() {
		Carry c = new Carry();
		c.setStatus("ฟหกดพภถรน");
		c.setCarryNumber("123456789356");

        try {
            entityManager.persist(c);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSuccess =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

    @Test
    public void testStatusNull() {
        Carry c = new Carry();
        c.setStatus(null);
        c.setCarryNumber("123456789356");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testStatusNull =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testCarryNumberNull() {
        Carry c = new Carry();
        c.setStatus("ฟหกดพภถรน");
        c.setCarryNumber(null);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testStatusNull =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testMinsizeStatus() {
        Carry c = new Carry();
        c.setStatus("ฟหก");
        c.setCarryNumber("123567897");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMinsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testMinsizeCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ฟหกดฟกกนรร");
        c.setCarryNumber("123");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMinsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testMaxsizeStatus() {
        Carry c = new Carry();
        c.setStatus("ฟหกดฟกกนรรฟหกดฟหกดเฟหกดฟหกดฟหก");
        c.setCarryNumber("1234567890");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testMaxsizeCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ฟหกดฟกกนรร");
        c.setCarryNumber("12345678945678934567834567834567");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeCarryNumber =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPatternDetailStatus() {
        Carry c = new Carry();
        c.setStatus("dfghjk");
        c.setCarryNumber("1234567890");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testPatternDetailStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPatternDetailCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ฟหกดฟกฟก");
        c.setCarryNumber("กดเหกหกหหป");

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeCarryNumber =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }


}
