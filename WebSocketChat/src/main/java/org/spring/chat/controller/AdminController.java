package org.spring.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/adminhome")
	public String adminPage() {
		System.out.println("당신은 관리자군요");
		return "admin/main";
	}
}
