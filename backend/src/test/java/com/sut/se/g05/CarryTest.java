package com.sut.se.g05;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;

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

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	

	@Test
	public void testSuccess() {
		Carry c = new Carry();
		c.setStatus("ส่งแล้ว");
		c.setCarryNumber("AVX1234566788");
		c.setNamecarry("wipawee sukkasem");
		c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSuccess =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatusNull() {
        Carry c = new Carry();
        c.setStatus(null);
        c.setCarryNumber("AVX1234566788");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testStatusNull =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCarryNumberNull() {
        Carry c = new Carry();
        c.setStatus("ส่งแล้ว");
        c.setCarryNumber(null);
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testStatusNull =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMinsizeStatus() {
        Carry c = new Carry();
        c.setStatus("ฟหก");
        c.setCarryNumber("AVX1234566788");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMinsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMinsizeCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ส่งแล้ว");
        c.setCarryNumber("123");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMinsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaxsizeStatus() {
        Carry c = new Carry();
        c.setStatus("ฟหกดฟกกนรรฟหกดฟหกดเฟหกดฟหกดฟหก");
        c.setCarryNumber("AVX1234566788");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaxsizeCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ส่งแล้ว");
        c.setCarryNumber("12345678945678934567834567834567");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeCarryNumber =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPatternDetailStatus() {
        Carry c = new Carry();
        c.setStatus("dfghjk");
        c.setCarryNumber("AVX1234566788");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testPatternDetailStatus =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPatternDetailCarryNumber() {
        Carry c = new Carry();
        c.setStatus("ส่งแล้ว");
        c.setCarryNumber("กดเหกหกหหป");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try {
            c.setDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testMaxsizeCarryNumber =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCarryNumberUnique() {
        Carry c = new Carry();
        c.setStatus("ส่งแล้ว");
        c.setCarryNumber("ASD123445566");
        c.setNamecarry("wipawee sukkasem");
        c.setCodenamecarry("H123344");

        try{

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM testCarryNumberUnique ======================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        } catch (javax.persistence.PersistenceException e) {
            System.out.println("==================================================================");
            e.printStackTrace();
        }

        Carry c1 = new Carry();
        c1.setStatus("ส่งแล้ว");
        c1.setCarryNumber("ASD123445566");
        c1.setNamecarry("wipawee sukkasem");
        c1.setCodenamecarry("H123344");

        try {

            entityManager.persist(c1);
            entityManager.flush();

        //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        System.out.println("==============================testUnique=============================");
        System.out.println(e);
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
    }
}


}
