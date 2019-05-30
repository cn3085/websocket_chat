package org.spring.chat.service;

import javax.annotation.Resource;


import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
@Service
public class PasswordEncoderEx {

		@Resource(name="passwordEncoder")
		BCryptPasswordEncoder encoder;
		
		public String encoding(String str) {
			return encoder.encode(str);
		}
}
