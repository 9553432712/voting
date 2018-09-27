package com.log.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.commondao.CommonDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class WelcomeController 
{
	@Autowired
	CommonDAO reg;
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
	@RequestMapping("/getStates")
	public String getStates()
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
		// Gson instances are Thread-safe so you can reuse them freely across multiple threads.
		Gson gson = gsonBuilder.create();
 
		String JSONObject = gson.toJson(reg.getStates());
		System.out.println(gson);
		return JSONObject;//(ArrayList) reg.getStates();
	}
	

}
