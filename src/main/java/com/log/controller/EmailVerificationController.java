package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.log.service.EmailVerificationService;

@RestController

public class EmailVerificationController {
	@Autowired
	EmailVerificationService emailVerifyService;
	@RequestMapping(value="emailverify",method=RequestMethod.GET)
	public ModelAndView verifyEmail(String emailTextUniqueId)
	{
		return emailVerifyService.emailIdVerify(emailTextUniqueId);
	}

}
