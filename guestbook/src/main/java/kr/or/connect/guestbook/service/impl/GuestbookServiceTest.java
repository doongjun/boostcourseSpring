package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

public class GuestbookServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		//addGuestbook
		/*
		Guestbook guestbook = new Guestbook();
		guestbook.setName("배다연");
		guestbook.setContent("저도 만나서 반갑습니다.");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
		*/
		
		//getGuestbooks
		/*
		List<Guestbook> list = guestbookService.getGuestbooks(0);
		for(Guestbook guest : list) {
			System.out.println(guest);
		}
		*/
		
		//deleteGuestbook
		System.out.println(guestbookService.deleteGuestbook((long) 5, "127.0.0.1"));
	}

}
