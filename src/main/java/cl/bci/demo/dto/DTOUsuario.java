package cl.bci.demo.dto;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Data;
@Validated
@Data
public class DTOUsuario {
	@JsonProperty ("user_name")
	@NotNull
	private  String  name;
	
	@NotNull
	@Email (message ="EMAIL NO VALIDO")
	private  String email;
	
	@NotNull
	private  String password;
	
	private  List<DTOPhone> phones;
	
	
	
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param phones
	 */
	public DTOUsuario(String name, String email, String password, List<DTOPhone> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	/**
	 * 
	 */
	public DTOUsuario() {
	}

}
