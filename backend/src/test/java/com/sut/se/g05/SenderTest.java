package com.sut.se.g05;

import com.sut.se.g05.entity.Sender;
import com.sut.se.g05.repository.SenderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@DataJpaTest
public class SenderTest {

    @Autowired
    private SenderRepository senderRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testAllCorrect() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            //entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println("======================================== Test All Correct ========================================");
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    public void testFirstNameNull() {
        Sender s = new Sender();
        s.setFirstname(null);
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Firstname ========================================");
            System.out.println();
        }
    }

    @Test
    public void testLastNameNull() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname(null);
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Lastname ========================================");
            System.out.println();
        }
    }

    @Test
    public void testMax() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("6518065180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Postcode Max ========================================");
            System.out.println();
        }
    }

    @Test
    public void testMin() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("095");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Phone Min ========================================");
            System.out.println();
        }
    }


    @Test
    public void testPatternPostcode() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180AB");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Pattern Postcode ========================================");
            System.out.println();
        }
    }


    @Test
    public void testPatternPhone() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("1956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Pattern Phone ========================================");
            System.out.println();
        }
    }

    @Test
    public void testPatternPassword() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123กขค");

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Pattern Password ========================================");
            System.out.println();
        }
    }

    @Test
    public void testValidation() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");
        entityManager.persist(s);
        entityManager.flush();

        Sender ss = new Sender();
        ss.setFirstname("แพรวโพยม");
        ss.setLastname("สอนสุภาพ");
        ss.setAddress("37/2");
        ss.setPostcode("65180");
        ss.setPhone("0956399315");
        ss.setEmail("ice@gmail.com");
        ss.setPassword("123");

        try {
            entityManager.persist(ss);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Pattern Password ========================================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test Pattern Password ========================================");
            e.printStackTrace();
        }
    }


    @Test(expected=javax.persistence.PersistenceException.class)
    public void testAddressUnique() {
        Sender s = new Sender();
        s.setFirstname("แพรวโพยม");
        s.setLastname("สอนสุภาพ");
        s.setAddress("37/2");
        s.setPostcode("65180");
        s.setPhone("0956399315");
        s.setEmail("ice@gmail.com");
        s.setPassword("123");
        entityManager.persist(s);
        entityManager.flush();


        Sender s1 = new Sender();
        s1.setFirstname("แพรวโพยม");
        s1.setLastname("สอนสุภาพ");
        s1.setAddress("37/2");
        s1.setPostcode("65180");
        s1.setPhone("0956399315");
        s1.setEmail("ice@gmail.com");
        s1.setPassword("123");
        entityManager.persist(s1);
        entityManager.flush();

        try {
            entityManager.persist(s1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test AddressUnique ========================================");
            System.out.println();
        }
    }


}
