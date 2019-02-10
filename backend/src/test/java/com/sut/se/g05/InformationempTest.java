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
public class InformationempTest {

    @Autowired
    private InformationempRepository informationRepository;

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
        Informationemp i = new Informationemp();

        i.setFirstname("kannika");
        i.setLastname("sittichai");
        i.setPhone("0815526893");
        i.setAddress("102");
        i.setBanknumber("123456");
        i.setEmail("kan@gmail.com");
        i.setPassword("123");

        informationRepository.save(i);

        try {
            entityManager.persist(i);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testFirstNameNull() {
        Informationemp i = new Informationemp();

        i.setFirstname(null);
        i.setLastname("sittichai");
        i.setPhone("0815526893");
        i.setAddress("102");
        i.setBanknumber("123456");
        i.setEmail("ice@gmail.com");
        i.setPassword("123");

        try {
            entityManager.persist(i);
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
    public void testPhoneL() {
        Informationemp i = new Informationemp();

        i.setFirstname("kannika");
        i.setLastname("sittichai");
        i.setPhone("00815526893");
        i.setAddress("102");
        i.setBanknumber("123456");
        i.setEmail("ice@gmail.com");
        i.setPassword("123");

        try {
            entityManager.persist(i);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Long Phonenumber====================");
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testPhoneS() {
        Informationemp i = new Informationemp();

        i.setFirstname("kannika");
        i.setLastname("sittichai");
        i.setPhone("815526893");
        i.setAddress("102");
        i.setBanknumber("123456");
        i.setEmail("ice@gmail.com");
        i.setPassword("123");

        try {
            entityManager.persist(i);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage()+"====================Error Test Short Phonenumber====================");
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void testPattern() {
        Informationemp i = new Informationemp();

        i.setFirstname("kannika");
        i.setLastname("sittichai");
        i.setPhone("00815526893");
        i.setAddress("102");
        i.setBanknumber("123456");
        i.setEmail("ice@gmail.com");
        i.setPassword("123");

        try {
            entityManager.persist(i);
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
