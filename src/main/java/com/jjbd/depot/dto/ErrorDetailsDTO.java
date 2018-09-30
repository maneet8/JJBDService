
package com.jjbd.depot.dto;

/**
 * 
 * Error Details DTo for Usage in Global Exception Controller
 */
public class ErrorDetailsDTO {
	
	  private String message;
	  private String details;

	  public ErrorDetailsDTO(String message, String details) {
	    super();
	    this.message = message;
	    this.details = details;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public String getDetails() {
	    return details;
	  }
}
