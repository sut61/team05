package com.sut.se.g05;

import com.sut.se.g05.entity.Comment;
import com.sut.se.g05.entity.Gender;
import com.sut.se.g05.repository.CommentRepository;
import com.sut.se.g05.repository.GenderRepository;
import com.sut.se.g05.repository.LevelRepository;
import com.sut.se.g05.repository.ProvinceRepository;
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
import java.util.Date;
import java.util.Set;
import java.sql.Timestamp;

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
		c.setPost("ทดสอบแสดงความคิดเเห็น1");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("ทดสอบแสดงความคิดเเห็น2");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost(null);
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("-");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("ทดสอบแสดงความคิดเเห็น3");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("ทดสอบแสดงความคิดเเห็น4");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("กขคง");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("abcd");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
		c.setPost("ABCD");
		c.setCommentDate(new Date());
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
	public void TestDateNull() {
		Comment c = new Comment();
		c.setName("สมบัติ");
		c.setPhone("0444444444");
		c.setPost("123456");
		c.setCommentDate(null);
		c.setCommentTime(new Timestamp(System.currentTimeMillis()));

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
	public void TestTimeNull() {
		Comment c = new Comment();
		c.setName("สมฤทัย");
		c.setPhone("0555555555");
		c.setPost("qwer");
		c.setCommentDate(new Date());
		c.setCommentTime(null);

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
		c1.setPost("ทดสอบ");
		c1.setCommentDate(new Date());
		c1.setCommentTime(new Timestamp(System.currentTimeMillis()));

		entityManager.persist(c1);
		entityManager.flush();

		Comment c2 = new Comment();
		c2.setName("สมหมาย");
		c2.setPhone("0123456789");
		c2.setPost("ทดสอบ");
		c2.setCommentDate(new Date());
		c2.setCommentTime(new Timestamp(System.currentTimeMillis()));

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

