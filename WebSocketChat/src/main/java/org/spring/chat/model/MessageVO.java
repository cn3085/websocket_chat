package org.spring.chat.model;

import com.google.gson.Gson;

import lombok.Data;

@Data
public class MessageVO {
	private String message;
	private String type;
	private String to;
	 
	public static MessageVO converMessage(String source) {
	    MessageVO message = new MessageVO();
	    Gson gson = new Gson();
	    message = gson.fromJson(source, MessageVO.class);
	 
	    return message;
	}
}
