package cl.bci.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.dto.DTOUsuarioResponse;
import cl.bci.demo.exceptions.EmailExisteException;
import cl.bci.demo.service.DemoService;
import cl.bci.demo.service.interfaces.IDemoService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/usuario")
@Slf4j

public class DemoController {
	@Autowired IDemoService ids;
	@RequestMapping(method = RequestMethod.POST, path="")
	public ResponseEntity <DTOUsuarioResponse> createUsuario ( @Valid @RequestBody DTOUsuario user) throws EmailExisteException  {
		DTOUsuarioResponse userResp= new DTOUsuarioResponse();
		
		try {
			userResp=	ids.create(user);
		} catch (EmailExisteException e) {
			log.error("Email existe en Base de Datos");
			throw new EmailExisteException("El correo ya existe",HttpStatus.BAD_REQUEST.value(),"/usuario");
		}
		
			return new ResponseEntity<DTOUsuarioResponse>(userResp,HttpStatus.CREATED);
	
	}
	
	
}
