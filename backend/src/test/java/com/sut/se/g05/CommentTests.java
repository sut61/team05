package com.sut.se.g05;

import com.sut.se.g05.entity.Comment;
import com.sut.se.g05.repository.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
//@SpringBootTest
@DataJpaTest
@AutoConfigurationPackage
public class CommentTests {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void TestSuccess() {
		Comment c = new Comment();
		c.setName("สมชาย");
		c.setPhone("0123456789");

		try{
			entityManager.persist(c);
			entityManager.flush();

			//fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("================ From TestSuccess =================");
			System.out.println(e);
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneNull() {
		Comment c = new Comment();
		c.setName("สมหญิง");
		c.setPhone(null);

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneNull =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneTooLong() {
		Comment c = new Comment();
		c.setName("AbCd");
		c.setPhone("01234567890123456789");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneTooLong =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneTooShort() {
		Comment c = new Comment();
		c.setName("สมนึก");
		c.setPhone("01");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneTooShort =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestPhoneWrongPattern() {
		Comment c = new Comment();
		c.setName("สมใจ");
		c.setPhone("abAB1234กข");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestPhoneWrongPattern =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestNameNull(){
		Comment c = new Comment();
		c.setName(null);
		c.setPhone("0123456789");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestNameTooShort =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestNameTooShort(){
		Comment c = new Comment();
		c.setName("ก");
		c.setPhone("0111111111");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestNameTooShort =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestNameTooLong(){
		Comment c = new Comment();
		c.setName("สมสมสมสมสมสมสมสมสมสมสม");
		c.setPhone("0222222222");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestNameTooLong =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestNameWrongPattern() {
		Comment c = new Comment();
		c.setName("123456789");
		c.setPhone("0333333333");

		try{
			entityManager.persist(c);
			entityManager.flush();

			fail("Should not pass to the line");
		} catch (javax.validation.ConstraintViolationException e){
			System.out.println("================ From TestNameWrongPattern =================");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void TestCommentUnique() {
		Comment c1 = new Comment();
		c1.setName("สมชาย");
		c1.setPhone("0123456789");

		entityManager.persist(c1);
		entityManager.flush();

		Comment c2 = new Comment();
		c2.setName("สมหมาย");
		c2.setPhone("0123456789");

		try{
			entityManager.persist(c2);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("================ From TestCommentUnique ======================");
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

