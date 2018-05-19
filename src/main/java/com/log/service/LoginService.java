package com.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController  
public class LoginService
{
	public boolean validateUser(String userid, String password) 
	{
		index();
        return userid.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("dummy");
	}
	@Autowired  
    JdbcTemplate jdbc;    
    //@RequestMapping("/insert")  
    public String index()
    {  
    	System.out.println("------------Entered"+jdbc);
        jdbc.execute("insert into login(name,pwd)values('javatpoint','java@javatpoint.com')");
        System.out.println("-------------------------");
        return"data inserted Successfully";  
    }  

}
