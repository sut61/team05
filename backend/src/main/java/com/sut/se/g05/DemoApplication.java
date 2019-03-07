package com.sut.se.g05;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.stream.Stream;
import java.util.Date;


@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(BankempRepository bankempRepository, CarInformationRepository carInformationRepository, CarRepository carRepository,
						   DamageRepository damageRepository, DriverRepository driverRepository, GenderRepository genderRepository,
						   InformationempRepository informationempRepository, LinkRepository linkRepository, LinkedRepository linkedRepository,
						   PackageRepository packageRepository, PositionRepository positionRepository, ProvinceRepository provinceRepository,
						   ReceiverRepository receiverRepository, RepairinfoRepository repairinfoRepository,
						   SenderRepository senderRepository, CarryRepository carryRepository, BillRepository billRepository,
						   PaidStatusRepository paidStatusRepository , DeduetionRepository deduetionRepository, LevelRepository levelRepository,
						   CommentRepository commentRepository, LinksenRepository linksenRepository, TypeproductRepository typeproductRepository,
						   BounceRepository bounceRepository, CarBrandRepository carBrandRepository, CarInsuranceRepository carInsuranceRepository,
						   CarcontrolRepository carcontrolRepository,CarStatusRepository carStatusRepository) {
		return args -> {

			Stream.of("อุปกรณ์อิเล็กทรอนิกส์","อุปกรณ์เครื่องเขียน","เสื้อผ้า","เครื่องสำอาง","กระเป๋า","รองเท้า","เครื่องประดับ").forEach(typeproducts -> {
				Typeproduct t = new Typeproduct();
				t.setTypeproduct(typeproducts);
				typeproductRepository.save(t);

			});

			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"
					,"ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
					,"นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา"
					,"พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน"
					,"ยะลา","ยโสธร","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล"
					,"สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย"
					,"หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(provinces -> {
				Province p = new Province();
				p.setProvince(provinces);
				provinceRepository.save(p);

			});

			Gender g = new Gender();
			g.setGender("ชาย");
			Gender g2 = new Gender();
			g2.setGender("หญิง");
			genderRepository.save(g);
			genderRepository.save(g2);

			Bounce a = new Bounce();
			a.setReason("สินค้าแตกหัก");
			a.setIce("iceice");
			Typeproduct t = typeproductRepository.findBytypeproduct("รองเท้า");
			a.setTypeproduct(t);

			Stream.of("อนุพงษ์","แพรวโพยม","สิริลักษณ์", "เบญจมาศ","ฐิติมากานต์").forEach(senders -> {
				Sender s = new Sender();
				s.setFirstname(senders);

				if(senders == "อนุพงษ์") {
					s.setLastname("ชัยสวรรค์");
					s.setAddress("sut");
					Province province = provinceRepository.findByprovince("นครราชสีมา");
					s.setProvince(province);
					s.setPostcode("65180");
					s.setPhone("0956399315");
					s.setEmail("ice1");
					s.setPassword("123");
					senderRepository.save(s);
					senderRepository.findAll().forEach(System.out::println);
				}

				else if (senders == "แพรวโพยม") {
					s.setLastname("ทองศรี");
					s.setAddress("moon");
					Province province = provinceRepository.findByprovince("พิษณุโลก");
					s.setProvince(province);
					s.setPostcode("65180");
					s.setPhone("0956399315");
					s.setEmail("ice2");
					s.setPassword("123");
					senderRepository.save(s);
					senderRepository.findAll().forEach(System.out::println);
				}

				else if (senders == "สิริลักษณ์") {
					s.setLastname("เกิดมี");
					s.setAddress("ii");
					Province province = provinceRepository.findByprovince("กรุงเทพมหานคร");
					s.setProvince(province);
					s.setPostcode("65180");
					s.setPhone("0956399315");
					s.setEmail("ice3");
					s.setPassword("123");
					senderRepository.save(s);
					senderRepository.findAll().forEach(System.out::println);
				}

				else if(senders == "เบญจมาศ") {
					s.setLastname("มัจฉา");
					s.setAddress("ocean");
					Province province = provinceRepository.findByprovince("บุรีรัมย์");
					s.setProvince(province);
					s.setPostcode("65180");
					s.setPhone("0956399315");
					s.setEmail("ice4");
					s.setPassword("123");
					senderRepository.save(s);
					senderRepository.findAll().forEach(System.out::println);
				}

				else if(senders == "ฐิติมากานต์") {
					s.setLastname("สอนสุภาพ");
					s.setAddress("hell");
					Province province = provinceRepository.findByprovince("นครราชสีมา");
					s.setProvince(province);
					s.setPostcode("65180");
					s.setPhone("0956399315");
					s.setEmail("ice5");
					s.setPassword("123");
					senderRepository.save(s);
					senderRepository.findAll().forEach(System.out::println);
				}

			});

			Stream.of("แพรวโพยม","ฐิติมากานต์","สิริลักษณ์", "เบญจมาศ","อนุพงษ์").forEach(receivers -> {
				Receiver r = new Receiver();
				r.setFirstname(receivers);
				receiverRepository.save(r);

				if (receivers == "แพรวโพยม") {
					r.setLastname("ทองศรี");
					r.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
					Province province = provinceRepository.findByprovince("พิษณุโลก");
					r.setProvince(province);
					r.setPostcode("65180");
					r.setPhone("0956399315");
					receiverRepository.save(r);
					receiverRepository.findAll().forEach(System.out::println);
				}

				else if(receivers == "ฐิติมากานต์") {
					r.setLastname("สอนสุภาพ");
					r.setAddress("37/2 หมู่3 ตำบลสุรนารี อำเภอเมืองนคราชสีมา");
					Province province = provinceRepository.findByprovince("นครราชสีมา");
					r.setProvince(province);
					r.setPostcode("65180");
					r.setPhone("0956399315");
					receiverRepository.save(r);
					receiverRepository.findAll().forEach(System.out::println);
				}

				else if (receivers == "สิริลักษณ์") {
					r.setLastname("เกิดมี");
					r.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
					Province province = provinceRepository.findByprovince("กรุงเทพมหานคร");
					r.setProvince(province);
					r.setPostcode("65180");
					r.setPhone("0956399315");
					receiverRepository.save(r);
					receiverRepository.findAll().forEach(System.out::println);
				}

				else if(receivers == "เบญจมาศ") {
					r.setLastname("มัจฉา");
					r.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
					Province province = provinceRepository.findByprovince("บุรีรัมย์");
					r.setProvince(province);
					r.setPostcode("65180");
					r.setPhone("0956399315");
					receiverRepository.save(r);
					receiverRepository.findAll().forEach(System.out::println);
				}

				else if(receivers == "อนุพงษ์") {
					r.setLastname("ชัยสวรรค์");
					r.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
					Province province = provinceRepository.findByprovince("นครราชสีมา");
					r.setProvince(province);
					r.setPostcode("65180");
					r.setPhone("0956399315");
					receiverRepository.save(r);
					receiverRepository.findAll().forEach(System.out::println);
				}

			});


			bounceRepository.save(a);
			bounceRepository.findAll().forEach(System.out::println);


			/////////////////////////////////////////////////////TAN////////////////////////////////////////////////////////////

			Stream.of("Toyota","Isuzu","Nissan").forEach(carbrand -> {
				CarBrand cb = new CarBrand();
				cb.setBrand(carbrand);
				carBrandRepository.save(cb);
			});

			Stream.of("รับ","ส่ง").forEach(Carstatus ->{
				CarStatus cStatus = new CarStatus();
				cStatus.setStatusType(Carstatus);
				carStatusRepository.save(cStatus);
			});

			CarBrand cb1 = carBrandRepository.getOne((long)1);
			CarBrand cb2 = carBrandRepository.getOne((long)2);
			CarBrand cb3 = carBrandRepository.getOne((long)3);
			Car c1 = new Car();
			c1.setBrand(cb1);
			c1.setLicenseplate("กกก99");
			Car c2 = new Car();
			c2.setBrand(cb2);
			c2.setLicenseplate("กก9999");
			Car c3 = new Car();
			c3.setBrand(cb3);
			c3.setLicenseplate("กก9990");

			carRepository.save(c1);
			carRepository.save(c2);
			carRepository.save(c3);

			CarInformation carInfo = new CarInformation();
				carInfo.setAddress("49/7 หมู่ 9 หมู่บ้านชลเทพ ต.บางพลีใหญ่ อ.บางพลี จ.สมุทรปราการ 10540");
				carInfo.setAge(20);
				carInfo.setTelephone("0988313467");
				carInfo.setName("tanzii");
				carInformationRepository.save(carInfo);
			
				Carcontrol control = new Carcontrol();
				control.setInformation(carInfo);
				control.setTime(new Date());				
				CarStatus cStatus = carStatusRepository.findByStatusType("ส่ง");
				control.setStatusType(cStatus);
				control.setAnnotation("สวัสดีวันนี้ไปส่งแล้วรถน้ำมัยหมดแย่มากๆเลยอ่ะ");
				carcontrolRepository.save(control);


			/////////////////////////////////////////////////////PIN////////////////////////////////////////////////////////////

			Stream.of("หม้อน้ำเสื่อมสภาพ","ยางรถยนตร์เสื่อมสภาพ","เครื่องยนตร์เสื่อมสภาพ","อุบัติเหตุทางรถยนตร์").forEach(damageName -> {
				Damage damage = new Damage();
				damage.setDamageName(damageName);
				damageRepository.save(damage);
			});


			Stream.of("สมชาย","สมหญิง","สมหมาย","สมศรี").forEach(driverName -> {
				Driver driver = new Driver();
				driver.setDriverName(driverName);
				driverRepository.save(driver);
			});

			Stream.of("น้อยที่สุด","น้อย","ปานกลาง","มาก","มากที่สุด").forEach(levelName -> {
				Level levels = new Level();
				levels.setLevelName(levelName);
				levelRepository.save(levels);
			});

			levelRepository.findAll().forEach(System.out::println);
			damageRepository.findAll().forEach(System.out::println);
			carRepository.findAll().forEach(System.out::println);
			driverRepository.findAll().forEach(System.out::println);

			/////////////////////////////////////////////////////NOOM////////////////////////////////////////////////////////////

			Informationemp e = new Informationemp();
			e.setFirstname("weerawat");
			e.setLastname("sangrai");
			e.setAddress("10112");
			e.setEmail("noom123");
			e.setPassword("1234");
			e.setPhone("0987654321");
			e.setBanknumber("012345678902");
			informationempRepository.save(e);

			Stream.of("จ่ายแล้ว","ยังไม่จ่าย","ไม่จ่าย","ชิ่ง").forEach(status -> {
				PaidStatus p = new PaidStatus();
				p.setStatus(status);
				paidStatusRepository.save(p);
			});


			/////////////////////////////////////////////////////GUN////////////////////////////////////////////////////////////

			Bankemp bankemp1 = new Bankemp("Thai Bank");
			bankempRepository.save(bankemp1);
			Bankemp bankemp2 = new Bankemp("K Bank");
			bankempRepository.save(bankemp2);


			Position position1 = new Position("Driver");
			positionRepository.save(position1);
			Position position2 = new Position("Manager");
			positionRepository.save(position2);
			Position position3 = new Position("Secretar");
			positionRepository.save(position3);
			Position position4 = new Position("HR");
			positionRepository.save(position4);

			Deduetion deduetion1 = new Deduetion("0");
			deduetionRepository.save(deduetion1);
			Deduetion deduetion2 = new Deduetion("500");
			deduetionRepository.save(deduetion2);
			Deduetion deduetion3 = new Deduetion("1000");
			deduetionRepository.save(deduetion3);
			Deduetion deduetion4 = new Deduetion("1500");
			deduetionRepository.save(deduetion4);
			Deduetion deduetion5 = new Deduetion("2000");
			deduetionRepository.save(deduetion5);
			Deduetion deduetion6 = new Deduetion("2500");
			deduetionRepository.save(deduetion6);
			Deduetion deduetion7 = new Deduetion("3000");
			deduetionRepository.save(deduetion7);
			Deduetion deduetion8 = new Deduetion("3500");
			deduetionRepository.save(deduetion8);
			Deduetion deduetion9 = new Deduetion("4000");
			deduetionRepository.save(deduetion9);


			deduetionRepository.findAll().forEach(System.out::println);
			bankempRepository.findAll().forEach(System.out::println);
			genderRepository.findAll().forEach(System.out::println);
			positionRepository.findAll().forEach(System.out::println);


			/////////////////////////////////////////////////////SHOOMPU////////////////////////////////////////////////////////////
			Receiver r = receiverRepository.getOne((long)1);
			Province p = provinceRepository.getOne((long)1);
			Carry carry = new Carry();
			carry.setDate(new Date());
			carry.setStatus("ส่งแล้ว");
			carry.setCarryNumber("AVX123456789");
			carry.setReceiver(r);
			carryRepository.save(carry);


			Linked linked = new Linked();
			linked.setCarryLinked(carry);
			linked.setProvinceLinked(p);
			linkedRepository.save(linked);

			Stream.of("PIN","ICE","ชาญวิทย์ประกันภัย").forEach(insurance -> {
				CarInsurance c = new CarInsurance();
				c.setCompany(insurance);
				carInsuranceRepository.save(c);
			});


			System.out.print("===================StartApplication=======================");
		};
	}
}
