package com.databaseCon;

import java.util.List;

public interface UserAccessBase {
	public int insert(UserAccess user) throws Exception;

	public int delete(String accessname) throws Exception;

	public int update(UserAccess user) throws Exception;

	public List<UserAccess> selecetAll() throws Exception;

	//public Userinfo selectById(int userid) throws Exception;
}
