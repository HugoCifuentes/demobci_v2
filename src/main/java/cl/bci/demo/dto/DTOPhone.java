package cl.bci.demo.dto;

import lombok.Data;

@Data 


public class DTOPhone {
	private String number;
	private String citycode;
	private String contrycode;
	
	
	/**
	 * @param number
	 * @param citycode
	 * @param contrycode
	 */
	public DTOPhone(String number, String citycode, String contrycode) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}
	
	
	/**
	 * 
	 */
	public DTOPhone() {
	}

}
