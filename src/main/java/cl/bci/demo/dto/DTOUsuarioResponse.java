package cl.bci.demo.dto;

import java.util.Date;

import lombok.Data;
@Data

public class DTOUsuarioResponse {
 private DTOUsuario usuario;
 private String id;
 private Date created;
 private Date modified;
 private Date last_login;
 private String token;
 private boolean isactive;
 
 
/**
 * @param usuario
 * @param id
 * @param created
 * @param modified
 * @param last_login
 * @param token
 * @param isactive
 */
public DTOUsuarioResponse(DTOUsuario usuario, String id, Date created, Date modified, Date last_login, String token,
		boolean isactive) {
	this.usuario = usuario;
	this.id = id;
	this.created = created;
	this.modified = modified;
	this.last_login = last_login;
	this.token = token;
	this.isactive = isactive;
}


/**
 * 
 */
public DTOUsuarioResponse() {
}

 
}
