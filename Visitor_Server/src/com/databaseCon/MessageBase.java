package com.databaseCon;

import java.util.List;

public interface MessageBase {
	public int insert(Message  me) throws Exception;

	public int delete(String name) throws Exception;

	public int update(Message  me) throws Exception;

	public List<Message> selecetAll() throws Exception;

	//public Message selectById(int meId) throws Exception;
	
}
