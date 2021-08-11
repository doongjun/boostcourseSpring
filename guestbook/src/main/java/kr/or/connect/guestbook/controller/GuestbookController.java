package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			ModelMap model, @CookieValue(value="count", defaultValue="0", required=true) String value, HttpServletResponse response) {
		
		try {
			int tmp = Integer.parseInt(value);
			value = Integer.toString(++tmp);
		}catch(Exception e) {
			value = "1";
		}
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 365); //1년
		//cookie.setMaxAge(-1); 브라우저가 종료될 때까지
		cookie.setPath("/"); // /경로 이하에 모든 쿠키 적용
		response.addCookie(cookie);
		
		List<Guestbook> guestbooks = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count/guestbookService.LIMIT;
		if(count%guestbookService.LIMIT > 0) {
			pageCount++;
		}
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; i++) {
			pageStartList.add(i * guestbookService.LIMIT);
		}
		
		model.addAttribute("guestbooks", guestbooks);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value);
		return "list";
	}
	
	@PostMapping(path="write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
			String clientIp = request.getRemoteAddr();
			System.out.println("clientIp" + clientIp);
			guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
	
	@GetMapping(path="delete")
	public String delete(@RequestParam(name="id", required=true)Long id,
			@SessionAttribute("isAdmin")String isAdmin,
			HttpServletRequest request,
			RedirectAttributes redirectAttr) {
		if("isAdmin"==null || !"true".equals(isAdmin)) {
			redirectAttr.addFlashAttribute("errorMessage", "로그인을 하지 않았습니다.");
			return "redirect:loginform";
		}
		String clientIp = request.getRemoteAddr();
		guestbookService.deleteGuestbook(id, clientIp);
		return "redirect:list";
	}
}
