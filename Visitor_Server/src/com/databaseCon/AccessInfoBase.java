package com.databaseCon;

import java.util.List;

public interface AccessInfoBase {
	public int insert(AccessInfo user) throws Exception;

	public int delete(String accessname) throws Exception;

	public int update(AccessInfo user) throws Exception;

	public List<AccessInfo> selecetAll() throws Exception;

	//public Userinfo selectById(int userid) throws Exception;
}
