package com.sut.se.g05;

import com.sut.se.g05.entity.*;
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

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigurationPackage
//@SpringBootConfiguration
@DataJpaTest
public class BillTests {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSetBill() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testNameNotNull() {
        Bill b = new Bill();
        b.setRecName(null);
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Name Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNameTooShort() {
        Bill b = new Bill();
        b.setRecName("pp");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Name Short=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNameTooLong() {
        Bill b = new Bill();
        b.setRecName("wearethailandnumbahwan");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Name Long=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNamePattern() {
        Bill b = new Bill();
        b.setRecName("we_rawat");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Name pattern=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhoneNotNull() {
        Bill b = new Bill();
        b.setRecName("ronaldo");
        b.setPhone(null);
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Phone Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhoneMustBeDigit() {
        Bill b = new Bill();
        b.setRecName("ronaldo");
        b.setPhone("onetwotree");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Phone Digit=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhoneInputShort() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("098765432");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Phone Too Short=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhoneTooLong() {
        Bill b = new Bill();
        b.setRecName("ronaldo");
        b.setPhone("09876543210");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Error Phone Too Long=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhoneMustBeUnique() {
        Bill b1 = new Bill();
        b1.setRecName("ronaldo");
        b1.setPhone("0987654321");
        b1.setPaid((long)5000);
        b1.setPaidDate(new Date());
        b1.setPaidTime(new Timestamp(System.currentTimeMillis()));
        entityManager.persist(b1);
        entityManager.flush();

        Bill b2 = new Bill();
        b2.setRecName("messi");
        b2.setPhone("0987654321");
        b2.setPaid((long)5000);
        b2.setPaidDate(new Date());
        b2.setPaidTime(new Timestamp(System.currentTimeMillis()));
        try {
            entityManager.persist(b2);
            entityManager.flush();
            fail("You shall not pass");
        }catch (PersistenceException e){
            e.getMessage();
            e.printStackTrace();
            System.out.println("=====Error Phone Unique=====");
        }
    }

    @Test
    public void testDateNotNull() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(null);
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Date Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTimeNotNull() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("0987654321");
        b.setPaid((long)5000);
        b.setPaidDate(new Date());
        b.setPaidTime(null);

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Time Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPaidNotNull() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("0987654321");
        b.setPaid(null);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Paid Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPaidPositive() {
        Bill b = new Bill();
        b.setRecName("messi");
        b.setPhone("0987654321");
        b.setPaid((long)-5000);
        b.setPaidDate(new Date());
        b.setPaidTime(new Timestamp(System.currentTimeMillis()));

        billRepository.save(b);

        try {
            entityManager.persist(b);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=====Date Null=====");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
