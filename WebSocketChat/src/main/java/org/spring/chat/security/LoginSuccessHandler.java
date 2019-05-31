package org.spring.chat.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.spring.chat.model.UserVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	//로그인 성공시
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserVO vo = (UserVO)authentication.getPrincipal();
		String msg = authentication.getName()+"님 환영합니다";
		request.setAttribute("msg", msg);
		System.out.println("로그인 서엉고옹");
		Enumeration<String> e=request.getSession().getAttributeNames();
		while(e.hasMoreElements()) {
			System.out.println("Session에 담긴 값 ");
			System.out.println(e.nextElement());
		}
		
		//시작 페이지 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	}

}
