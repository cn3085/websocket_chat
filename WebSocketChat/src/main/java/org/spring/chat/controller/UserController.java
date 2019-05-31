package org.spring.chat.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.spring.chat.model.UserVO;
import org.spring.chat.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	UserService userService;
	
	@Inject
	BCryptPasswordEncoder encoder;
	
	@PostMapping("/regist")
	public void registUser(UserVO vo) {
		System.out.println("UserController의 register가 실행됩니다");
		Map<String, String> map = new HashMap<>();
		int result = userService.insertUser(map);
		
		System.out.println("결과는 : " + result);
	}
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("로그인 폼으로 보낸다");
		return "users/loginForm";
	}
	
//	@RequestMapping("/check")
//	//UserDetailService를 구현한 클래스가 실행됨
//	public String checkUser(String username) {
//		System.out.println("UserController의 checker가 실행됩니다");
//		Object result = userService.selectUser(username);
//		
//		System.out.println("결과는 : " + result);
//		return "home";
//	}
	
	@GetMapping("/join")
	public String joinUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		SecurityContext value = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");

		Authentication authentication = value.getAuthentication();

		User principal = (User) authentication.getPrincipal();

		WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

		String username = authentication.getName();

		System.out.println("username------------");
		System.out.println(username);
		return "users/joinForm";
	}
	
	@PostMapping("/joinAction")
	public String joinUser(String username, String password, String authority) {
		System.out.println(username + password + authority);
		String dbpw = encoder.encode(password);
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", dbpw);
		map.put("authority", authority);
		int result = userService.insertUser(map);
		return "users/loginForm";
	}
	
//	@RequestMapping("/admin")
//	public String adminPage() {
//		System.out.println("당신은 관리자군요");
//		return "admin/main";
//	}
}
