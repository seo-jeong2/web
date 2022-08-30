package com.gd.web0830.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


import lombok.extern.slf4j.Slf4j;


@Slf4j //lombok사용 : 코드로 구현해야 할 것을 쉽게 할 수있게 모아놓음 autowired Log log;
@RestController
@SessionAttributes(value="loginId")
public class HelloController {
	
//	@GetMapping({"/hello","/"})
//	public String hello() {
//		log.debug(TeamColor.PCW+"hello");
//		log.debug(TeamColor.PSJ+"hello");
//		log.debug(TeamColor.PSY+"hello");
//		log.debug(TeamColor.LHN+"hello");
//		
//		
//		return "hello";
//	}
//	
	
	//컨트롤러 메서드의 매개변수에 HttpSession session 타입을 받으면 servlet api 의 세션을 받아 사용하게 된다.
	@PostMapping("/login")
	public Boolean login(HttpSession session, @RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		final String userId = "admin";
		final String userPw = "1234";
		if(id.equals(userId) && pw.equals(userPw)) {
			session.setAttribute("loginId", "id");
				return true;
		}
			return false;
	}
	
	@PostMapping("/login2")
	public Boolean login2(Model model, @RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		final String userId = "admin";
		final String userPw = "1234";
		if(id.equals(userId) && pw.equals(userPw)) {
			model.addAttribute("loginId", id); //디폴트 request속성과 생명주기 같이한다.
				return true;
		}
			return false;
	}
	
	
	

	@GetMapping("/boardOne")
	public String boardOne(@RequestParam(value="boardNo") int boardNo) {
		log.debug("boardOne boardNo : " + boardNo);
		return boardNo+"";
		
	}
	
	
	@GetMapping("/boardOne2/{boardNo}")
	public Integer boardOne2(@PathVariable(value="boardNo") int boardNo) {
		log.debug("/boardOne2 boardNo : " + boardNo);
		return boardNo;
	}
}
