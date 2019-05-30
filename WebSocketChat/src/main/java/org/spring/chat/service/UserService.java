package org.spring.chat.service;

import java.util.Map;

import javax.inject.Inject;

import org.spring.chat.mapper.UserMapper;
import org.spring.chat.model.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Inject
	UserMapper mapper;
	
	public int insertUser(Map<String, String> map) {
		int result = mapper.insertUser(map);
		return result;
	}
	
	public Map<String, Object> selectUser(String userId) {
		Map<String, Object> result = mapper.selectUser(userId);
		return result;
	}
}
