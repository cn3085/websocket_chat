package org.spring.chat.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {
//로그인 실패했을 때 처리
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
		System.out.println("로그인 실패 ㅠㅠㅠㅠㅠㅠㅠㅠ");

		String url = "/WEB-INF/views/users/loginForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
