package com.sut.se.g05;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BounceTest {

    @Autowired
    private BounceRepository bounceRepository;

    @Autowired
    private TypeproductRepository typeproductRepository;

    @Autowired
    private SenderRepository senderRepository;

    @Autowired
    private ReceiverRepository receiverRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testBounceAllCorrect() {
        Bounce a = new Bounce();
        a.setReason("สินค้าแตกหัก");
        a.setOther("iiiiii");
        a.setSender(senderRepository.findByfirstname("ก"));
        a.setReceiver(receiverRepository.findByfirstname("ข"));
        a.setProvince(provinceRepository.findByprovince("ค"));

        try {
            entityManager.persist(a);
            entityManager.flush();
//            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println( "======================================== Test BounceAllCorrect ========================================");
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testReasonNull() {
        Bounce a = new Bounce();
        a.setReason(null);
        a.setOther("iiiiii");
        a.setSender(senderRepository.findByfirstname("ก"));
        a.setReceiver(receiverRepository.findByfirstname("ข"));
        a.setProvince(provinceRepository.findByprovince("ค"));

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage()+"======================================== Test Reason Null ========================================");
            System.out.println();
        }
    }

    @Test
    public void testReasonMin() {
        Bounce a = new Bounce();
        a.setReason("กขค");
        a.setOther("ii");
        a.setSender(senderRepository.findByfirstname("ก"));
        a.setReceiver(receiverRepository.findByfirstname("ข"));
        a.setProvince(provinceRepository.findByprovince("ค"));

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage()+"======================================== Test Reason Min ========================================");
            System.out.println();
        }
    }

    @Test
    public void testReasonPattern() {
        Bounce a = new Bounce();
        a.setReason("กขค123");
        a.setOther("iiiiii");
        a.setSender(senderRepository.findByfirstname("ก"));
        a.setReceiver(receiverRepository.findByfirstname("ข"));
        a.setProvince(provinceRepository.findByprovince("ค"));

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage()+"======================================== Test Reason Pattern ========================================");
            System.out.println();
        }
    }

    @Test
    public void testTypeproductAllCorrect() {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct("iiiiii");

        try {
            entityManager.persist(t);
            entityManager.flush();
//            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println( "======================================== Test TypeproductAllCorrect ========================================");
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTypeproductNull() {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct(null);

        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage()+"======================================== Test Typeproduct Null ========================================");
            System.out.println();
        }
    }

    @Test
    public void testTypeproductMin() {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct("ii");

        try {
            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage()+"======================================== Test Typeproduct Min ========================================");
            System.out.println();
        }
    }

    @Test(expected=javax.persistence.PersistenceException.class)
    public void testTypeproductUnique() {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct("iiiiii");
        entityManager.persist(t);
        entityManager.flush();

        Typeproduct t1 = new Typeproduct();
        t1.setTypeproduct("iiiiii");
        entityManager.persist(t1);
        entityManager.flush();

        try {
            entityManager.persist(t1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e.getMessage() + "======================================== Test TypeproductUnique ========================================");
            System.out.println();
        }
    }

}
