package org.spring.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.log4j.Log4j;



@Controller
@Log4j
public class ChatController {
	@RequestMapping("/echo")
	public ModelAndView chat(ModelAndView mv) {
		mv.setViewName("chat/chattingview");
		log.info("누가누가 먼저니");
		return mv;
	}
}
