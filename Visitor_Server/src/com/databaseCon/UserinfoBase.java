package com.databaseCon;

import java.util.List;

import com.databaseCon.Userinfo;

public interface UserinfoBase {
	public int insert(Userinfo user) throws Exception;

	public int delete(int userid) throws Exception;

	public int update(Userinfo user) throws Exception;

	public List<Userinfo> selecetAll() throws Exception;

	public List<Userinfo> selectById(String userid) throws Exception;

}
