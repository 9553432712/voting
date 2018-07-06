package com.log.dao;

import java.util.List;

public interface AdminDAO {
	
	public boolean checkForAdminAccess(String email, String password,String roleId);
	public List getUserData();

}
