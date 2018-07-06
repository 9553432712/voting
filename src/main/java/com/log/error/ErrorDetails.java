package com.log.error;

import java.util.Date;

public class ErrorDetails {
  private Date timestamp;
  private String message;
  private String details;

  public ErrorDetails(Date timestamp, String message, String details) 
  {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
  }
  public String toString()
  {
	  return message+"\t"+details+"\n"+timestamp;
  }
}