package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.log.service.LoginService;
import com.log.util.EMailService;

@Controller
@SessionAttributes("name")
public class LoginController
{
	@Autowired
    LoginService service;
    @RequestMapping("/login")
    public String showLoginPage(ModelMap model)
    {
    	System.out.println("-----------login Page=----------------");
        return "login";
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    //public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    {
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) 
        {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
    @RequestMapping(value="/mahesh", method = RequestMethod.GET)
    //public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    public String showMaheshPage()//, @RequestParam String name, @RequestParam String password)
    {
    	EMailService email = new EMailService();
		return "welcome";
    }
    
    @RequestMapping(value="/getData", method = RequestMethod.GET)
    //public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    public String getUserData()//, @RequestParam String name, @RequestParam String password)
    {
    	EMailService email = new EMailService();
		return "welcome";
    }
    
    
    

}
