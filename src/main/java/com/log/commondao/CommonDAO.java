package com.log.commondao;

import java.util.ArrayList;
import java.util.List;

public interface CommonDAO 
{
	public List getStates();
	public List getDistricts(String stateId) ;
	public List getCities(String stateId, String districtId);
	public List getColleges(String stateId, String districtId, String cityId);
	public String generateUserID();
	
	public void sendMSG(String phone);
	public void sendMail(String email);
	
	public ArrayList getUserData();
	

}
