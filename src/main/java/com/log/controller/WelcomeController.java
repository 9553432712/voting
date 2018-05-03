package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{
	//Spring to manage to create instance of this bean
	@Component
	class WelcomeService
	{
		public String welcomeMSG()
		{
			return "Welcome Mahesh";
			
		}
	}
	//AutoWire this
	@Autowired
	WelcomeService service ;//Dependency
	@RequestMapping("/welcome")
	public String welcome()
	{
		return service.welcomeMSG();
	}
	

}
