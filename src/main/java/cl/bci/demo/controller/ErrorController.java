package cl.bci.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.bci.demo.exceptions.EmailExisteException;
import cl.bci.demo.exceptios.objets.ErrorUsuario;

@ControllerAdvice
public class ErrorController {
	
	
	@ExceptionHandler({EmailExisteException.class})
	public ResponseEntity<ErrorUsuario> handleMethodArgumentNotValid(HttpServletRequest request, EmailExisteException e) {
		ErrorUsuario errorInfo = new ErrorUsuario("El correo ya se encuentra registrado", HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
	       return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorUsuario> handleAllExceptions(HttpServletRequest request, ErrorUsuario e) {
		ErrorUsuario errorInfo = new ErrorUsuario("Error Generico", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI());
	       return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	   }

}
