package com.sut.se.g05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
//@AutoConfigureDataJpa
public class SalaryTest {

    @Autowired
    private SalaryRepository SalaryRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testNull() {
        Salary s = new Salary();

        s.setName("kannika");
        s.setBanknumber("012345678901");
        s.setBalance(20000);

        try {
            entityManager.persist(s);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testFirstNameNull() {
        Salary s = new Salary();

        s.setName(null);
        s.setBanknumber("012345678901");
        s.setBalance(20000);

        try {
            entityManager.persist(s);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Null====================");
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testNameL() {
        Salary s = new Salary();

        s.setName("kkkkkkkkkkkkkkkkkkk");
        s.setBanknumber("012345678901");
        s.setBalance(20000);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Long Name====================");
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testNameS() {
        Salary s = new Salary();

        s.setName("k");
        s.setBanknumber("012345678901");
        s.setBalance(20000);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Short Name====================");
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testPattern() {
        Salary s = new Salary();

        s.setName("k");
        s.setBanknumber("0123456789010000");
        s.setBalance(20000);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Pattern====================");
            System.out.println();
            System.out.println();
        }
    }


}
