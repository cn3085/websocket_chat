package org.spring.chat.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.spring.chat.model.UserVO;
import org.spring.chat.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAuthService implements UserDetailsService  {

	@Inject
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Map<String, Object> user = userService.selectUser(username);
		System.out.println(user.get("authority"));
		//아이디가 없으면 예외 발생
		//비밀번호 체크는? 알아서 해주고 있음
		if(user==null) throw new UsernameNotFoundException(username);
		//사용 권한 가져옴
		List<GrantedAuthority> authority = new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(
				user.get("authority").toString()
				));
		return new UserVO(user.get("username").toString(),
				user.get("password").toString(),
				true, true, true, true, authority,
				user.get("username").toString());
	}
	
	

}
