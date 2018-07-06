package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.log.commondao.CommonDAO;
import com.log.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CommonDAO com;
	@Autowired
	AdminService adser;
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showAdminLoginPage()
    {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
        return model;
    }
	@RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView showAdminLoginPage1()
    {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
        return model;
    }
	@RequestMapping(value="/getData", method = RequestMethod.POST)
    //public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    public ModelAndView showUsersDataPage(ModelMap mode, @RequestParam String email, @RequestParam String password)
    {
		System.out.println("Voting Admin----"+email+password);
		
		//AdminService adser = new AdminService();
		
		ModelAndView model = new ModelAndView();
		if( email==null || password==null || !adser.checkAdminAccess(email,password,"2"))
		{
            model.addObject("errorMSG", "Invalid Credentials");
            model.setViewName("error");
            return model;
        }
		model.addObject("userData", adser.getUserData());
		model.setViewName("userdata");
		System.out.println();
        return model;
    }
	

}
