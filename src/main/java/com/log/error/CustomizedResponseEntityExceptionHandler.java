package com.log.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
@RestController

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public final ModelAndView handleAllExceptions(Exception ex, WebRequest request) {
	  
	  System.out.println("11111111111112222222222222222233333333333333333334444444444444444"+ex);
	  
	  //LOGGER.trace("handleAllExceptions needed more information - {}", ex);
      //LOGGER.debug("handleAllExceptions needed to debug - {}", ex);
      //LOGGER.info("handleAllExceptions took input - {}", ex);
      //LOGGER.warn("handleAllExceptions needed to warn - {}", ex);
      LOGGER.error("handleAllExceptions encountered an error with value - {}", ex);
	  
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    ModelAndView model = new ModelAndView();
    model.setViewName("error");
    model.addObject("errorMSG",""+errorDetails+"<br>"+HttpStatus.INTERNAL_SERVER_ERROR+"<br>"+request.getContextPath()+"<br>"+request);
    //return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    return model;
  }
}