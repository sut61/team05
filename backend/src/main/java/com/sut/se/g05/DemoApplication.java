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


@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(GenderRepository genderRepository, ProvinceRepository provinceRepository,
						   LinkRepository linkRepository, SenderRepository senderRepository,
						   ReceiverRepository receiverRepository, ProvincesenRepository provincesenRepository) {
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
			s.setFirstnamesen("แพรวโพยม");
			s.setLastnamesen("สอนสุภาพ");
			s.setAddresssen("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			s.setPostcodesen("65180");
			s.setPhonesen("0956399315");
			s.setEmail("ice@gmail.com");
			s.setPassword("123");

			Receiver r = new Receiver();
			r.setFirstnamerec("แพรวโพยม");
			r.setLastnamerec("สอนสุภาพ");
			r.setAddressrec("37/2 หมู่3 ตำบลดงประคำ อำเภอพรหมพิราม");
			r.setPostcoderec("65180");
			r.setPhonerec("0956399315");

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

		};
	}
}