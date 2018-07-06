package com.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.log.dao.EmailVerificationDAO;

@Service
public class EmailVerificationService {
	
	@Autowired
	EmailVerificationDAO emailVerifyDao;
	
	public ModelAndView emailIdVerify(String emailTextUniqueId)
	{
		ModelAndView model = new ModelAndView();
		if(emailVerifyDao.emailIdVerify(emailTextUniqueId))
		{
			//emailVerifyDao.updateFlag();
			model.setViewName("success");
			model.addObject("successMSG","Email Verified Successfully");
		}
		else
		{
			model.setViewName("error");
			model.addObject("errorMSG","Email not Verified!! Something went wrong!!! Please try again after some time");
		}
		return model;
		
	}

}
