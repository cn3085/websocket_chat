package org.spring.chat.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class UserDeniedHandler implements AccessDeniedHandler {
	//사용 권한이 없ㅇ르 때 지정한 페이지로 이동
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		request.setAttribute("errMsg", "관리자만 사용할 수 잇는 기능입니다.");
		String url = "/WEB-INF/views/user/denied.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}
	
}
