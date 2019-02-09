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
						   ProvincesenRepository provincesenRepository, ReceiverRepository receiverRepository, RepairinfoRepository repairinfoRepository,
						   SenderRepository senderRepository, CarryRepository carryRepository, BillRepository billRepository,
						   PaidStatusRepository paidStatusRepository , DeduetionRepository deduetionRepository) {
		return args -> {
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

				Provincesen ps = new Provincesen();
				ps.setProvincesen(provinces);
				provincesenRepository.save(ps);

			});

			Gender g = new Gender();
			g.setGender("ชาย");
			Gender g2 = new Gender();
			g2.setGender("หญิง");
			genderRepository.save(g);
			genderRepository.save(g2);

			Sender s = new Sender();
			s.setFirstname("แพรวโพยม");
			s.setLastname("สอนสุภาพ");
			s.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			s.setPostcode("65180");
			s.setPhone("0956399315");
			s.setEmail("ice@gmail.com");
			s.setPassword("123");

			Receiver r = new Receiver();
			r.setFirstname("แพรวโพยม");
			r.setLastname("สอนสุภาพ");
			r.setAddress("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			r.setPostcode("65180");
			r.setPhone("0956399315");

			Gender gender = genderRepository.findBygender("ชาย");
			Gender gender2 = genderRepository.findBygender("หญิง");
			s.setGender(gender);
			s.setGender(gender2);

			Province province = provinceRepository.findByprovince("พิษณุโลก");
			r.setProvince(province);
			Provincesen provincesen = provincesenRepository.findByprovincesen("พิษณุโลก");
			s.setProvincesen(provincesen);


			senderRepository.save(s);
			senderRepository.findAll().forEach(System.out::println);
			receiverRepository.save(r);
			receiverRepository.findAll().forEach(System.out::println);

			/////////////////////////////////////////////////////TAN////////////////////////////////////////////////////////////

			Car c1 = new Car();
			c1.setCarbrand("จักยานสี่ล้อ");
			c1.setLicenseplate("กก-99");
			Car c2 = new Car();
			c2.setCarbrand("กะบะห้าล้อ");
			c2.setLicenseplate("กก-999");
			Car c3 = new Car();
			c3.setCarbrand("รถพ่วง25ล้อ");
			c3.setLicenseplate("กก-9999");

			carRepository.save(c1);
			carRepository.save(c2);
			carRepository.save(c3);


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
			e.setPhone("555");
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

			Carry carry = new Carry();
			carry.setDate(new Date());
			carry.setStatus("ส่งแล้ว");
			carry.setCarryNumber("AVX123456789");
			carry.setReceiver(r);
			carryRepository.save(carry);


			Linked linked = new Linked();
			linked.setCarryLinked(carry);
			linked.setProvinceLinked(province);
			linkedRepository.save(linked);



			System.out.print("===================StartApplication=======================");
		};
	}
}