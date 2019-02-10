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

        try {
            entityManager.persist(a);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println( "======================================== Test BounceAllCorrect ========================================");
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTypeproductAllCorrect() {
        Typeproduct t = new Typeproduct();
        t.setTypeproduct("รองเท้า");

        try {
            entityManager.persist(t);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println( "======================================== Test TypeproductAllCorrect ========================================");
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
}
