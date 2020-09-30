package cl.bci.demo.exceptios.objets;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorUsuario {
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
	public ErrorUsuario(String message, int statusCode, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}
		   
}
