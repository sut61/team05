package com.sut.se.g05;

import com.sut.se.g05.entity.Car;
import com.sut.se.g05.entity.CarInformation;
import com.sut.se.g05.entity.Driver;
import com.sut.se.g05.entity.Repairinfo;
import com.sut.se.g05.repository.CarRepository;
import com.sut.se.g05.repository.CarInformationRepository;
import com.sut.se.g05.repository.DamageRepository;
import com.sut.se.g05.repository.DriverRepository;
import com.sut.se.g05.repository.RepairinfoRepository;
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
import java.sql.Timestamp;
import java.util.Set;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigurationPackage
public class RepairinfoTests {

	@Autowired
	private RepairinfoRepository repairinfoRepository;

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
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมชาย");
		r.setPhone("0123456789");
		r.setNote("abAB กข12");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมหญิง");
		r.setPhone(null);
		r.setNote("AB");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("AbCd");
		r.setPhone("01234567890123456789");
		r.setNote("ab");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมนึก");
		r.setPhone("01");
		r.setNote("กข");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมใจ");
		r.setPhone("abAB1234กข");
		r.setNote("12");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestNameEmpNull() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName(null);
		r.setPhone("0123456789");
		r.setNote("cd");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestNameEmpTooShort() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("ก");
		r.setPhone("0111111111");
		r.setNote("C D");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestNameEmpTooLong() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมสมสมสมสมสมสมสมสมสมสม");
		r.setPhone("0222222222");
		r.setNote("-");
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestNameEmpWrongPatterng() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("123456789");
		r.setPhone("0333333333");
		r.setNote(null);
		r.setRepairDate(new Date());
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestDateNull() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมบัติ");
		r.setPhone("0444444444");
		r.setNote(null);
		r.setRepairDate(null);
		r.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r);
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
	public void TestTimeNull() {
		Repairinfo r = new Repairinfo();
		r.setEmployeeName("สมฤทัย");
		r.setPhone("0555555555");
		r.setNote(null);
		r.setRepairDate(new Date());
		r.setRepairTime(null);

		try{
			entityManager.persist(r);
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
	public void TestRepairinfoUnique() {
		Repairinfo r1 = new Repairinfo();
		r1.setEmployeeName("สมหมาย");
		r1.setPhone("0123456789");
		r1.setNote("ab");
		r1.setRepairDate(new Date());
		r1.setRepairTime(new Timestamp(System.currentTimeMillis()));

		entityManager.persist(r1);
		entityManager.flush();

		Repairinfo r2 = new Repairinfo();
		r2.setEmployeeName("สมศรี");
		r2.setPhone("0123456789");
		r2.setNote("cd");
		r2.setRepairDate(new Date());
		r2.setRepairTime(new Timestamp(System.currentTimeMillis()));

		try{
			entityManager.persist(r2);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("================ From TestRepairinfoUnique ======================");
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

