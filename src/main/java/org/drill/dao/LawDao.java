package org.drill.dao;

import org.drill.model.po.Information;

public interface LawDao {

	public int selectUsers(String username,String password);
	
	public void save(Information information);
}
