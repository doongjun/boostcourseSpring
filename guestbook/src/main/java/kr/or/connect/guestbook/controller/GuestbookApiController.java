package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue = "0") int start){
		List<Guestbook> guestbooks = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count/guestbookService.LIMIT;
		if(count%guestbookService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; i++) {
			pageStartList.add(i * guestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("guestbooks", guestbooks);
		map.put("pageStartList", pageStartList);
		map.put("count", count);
		
		return map;
	}
	
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook,
			HttpServletRequest request) {
		String clientId = request.getRemoteAddr();
		Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientId);
		
		return resultGuestbook;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request){
		String clientIp = request.getRemoteAddr();
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0? "true":"false");
	}
}
