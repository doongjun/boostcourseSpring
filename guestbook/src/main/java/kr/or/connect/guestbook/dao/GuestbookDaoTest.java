package kr.or.connect.guestbook.dao;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		Guestbook guestbook = new Guestbook();
		
		//insert
		/*
		guestbook.setName("김동준");
		guestbook.setContent("개발자입니다.");
		guestbook.setRegdate(new Date());
		
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);
		*/
		
		//selectAll
		/*
		List<Guestbook> list = guestbookDao.selectAll(0, 5);
		for(Guestbook guest : list) {
			System.out.println(guest);
		}
		*/
		
		//delete
		//System.out.println(guestbookDao.deleteById(3));
		
		//count
		System.out.println(guestbookDao.selectCount());
		
	}

}
