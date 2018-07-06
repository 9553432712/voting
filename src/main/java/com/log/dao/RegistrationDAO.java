package com.log.dao;

import java.util.HashMap;

public interface RegistrationDAO 
{
	public int registerUser(HashMap<String,String> newUserData);
	public boolean checkUserExist(String email);
	public String getTextForEmail(String emailId);

}
