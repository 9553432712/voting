package com.log.configuration;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {
	public static String url;
	
	//@Value(HttpServletRequest.getContextPath())
	private void setUrl(String url1)
	{
		url = url1;
	}

}
