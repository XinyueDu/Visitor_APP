package com.databaseCon;

import java.util.List;

public interface ContactBase {
	public int insert(Contact  co) throws Exception;

	public int delete(String name) throws Exception;

	public int update(Contact  co) throws Exception;

	public List<Contact>  selectById( String userid) throws Exception;

}
