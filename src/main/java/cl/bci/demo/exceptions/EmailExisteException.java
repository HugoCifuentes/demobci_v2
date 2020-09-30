package cl.bci.demo.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class EmailExisteException extends Exception{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -698298885573018167L;
	
@JsonProperty("message")
   private String message;
   @JsonProperty("status_code")
   private int statusCode;
   @JsonProperty("uri")
   private String uriRequested;
   
   

/**
 * @param message
 * @param statusCode
 * @param uriRequested
 */
public EmailExisteException(String message, int statusCode, String uriRequested) {
	this.message = message;
	this.statusCode = statusCode;
	this.uriRequested = uriRequested;
}

public EmailExisteException() {
	
}
		
		

   
}
