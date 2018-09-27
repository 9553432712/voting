//package com.in28minutes.springboot;
package com.log.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import com.log.util.EMailService;

@SpringBootApplication
@ComponentScan("com.log")
@ComponentScan(basePackages = "com.log")
public class Application 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired 
    EMailService emil;
}



