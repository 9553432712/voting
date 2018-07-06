package com.log.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import com.log.commondao.CommonDAO;
import com.log.dao.RegistrationDAO;
import com.log.util.AjaxResponseBody;
import com.log.util.CommonUtility;

@Component
public class RegistrationService 
{
	RegistrationDAO regDao;
	CommonDAO comDAO;

	public RegistrationService(CommonDAO comDAO, RegistrationDAO regDao)
	{
		this.comDAO = comDAO;
		this.regDao = regDao;
	}
	public ModelAndView getStates(ModelAndView model)
	{		 
				model.setViewName("/registration");
				model.addObject("statesList",  comDAO.getStates());
				return model;
	}
	public ModelAndView insertNewUser(MultiValueMap<String, String> map)
	{
		ModelAndView model = new ModelAndView();
		HashMap<String,String> userData = new HashMap<String,String>(); 
		userData = CommonUtility.convertMultiToRegularMap(map);
		//RegistrationDAO reg = new RegistrationDAOImpl();
		String emailId = userData.get("email");
		if(regDao.checkUserExist(emailId))
		{
			System.out.println("Mahesh 0000000 true");
			AjaxResponseBody ajax = new AjaxResponseBody();
			model.setViewName("error");
			model.addObject("errorMSG","The user is already exist");
			ajax.setResultMSG("error");
			return model;
		}
		regDao.registerUser(userData);
		model.setViewName("vote");
		model.addObject("successMSG","Registration has been successful!!!! Please Vote!!!");
	/*	model.setViewName("success");
		model.addObject("successMSG","Thanks for Registration!!! Please verify your Email Id to  Vote!!!!");*/
		return model;
    
	}
}
