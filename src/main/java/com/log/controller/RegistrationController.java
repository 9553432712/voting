package com.log.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.log.commondao.CommonDAO;
import com.log.dao.RegistrationDAOImpl;
import com.log.error.CustomizedResponseEntityExceptionHandler;
import com.log.service.RegistrationService;
@Controller
public class RegistrationController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	RegistrationDAOImpl regDAo;
	@Autowired
	CommonDAO cdao;

	@Autowired
	RegistrationService reg;
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage()
    {
		LOGGER.info("\n Class RegistrationController method showRegistrationPage() Entered Mahesh----------------------");
		ModelAndView model = new ModelAndView();
		return reg.getStates(model);
    }
	@RequestMapping("/registrationSubmit")
	public ModelAndView registrationSubmit(@RequestBody MultiValueMap<String, String> map, HttpServletRequest req)
    {
		LOGGER.info("\n Class RegistrationController method registrationSubmit() Entered Mahesh----------------------");;
		//RegistrationService reg = new RegistrationService();
		return reg.insertNewUser(map);
    }
	@RequestMapping("/")
	public String homePage()
    {
		LOGGER.info("\n Class RegistrationController method homePage() Entered Mahesh----------------------");
		ModelAndView model = new ModelAndView();
		model.setViewName("registration");
		//return model;
		//return "redirect:/register";
		return "index";
    }

}
