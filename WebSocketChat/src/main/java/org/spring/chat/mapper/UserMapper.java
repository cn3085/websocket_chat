package org.spring.chat.mapper;

import java.util.Map;

import org.spring.chat.model.UserVO;

public interface UserMapper {

	public int insertUser(Map<String, String> map);
	public Map<String, Object> selectUser(String userId);
}
