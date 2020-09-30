package cl.bci.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.bci.demo.dto.DTOPhone;
import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.dto.DTOUsuarioResponse;
import cl.bci.demo.exceptions.EmailExisteException;
import cl.bci.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class DemoServiceTests {
	@Autowired 
	DemoService dms;

	

	
	@Test
	void contextLoads() {
		//lleana el objeto usuario
			
		try {
			
			DTOUsuarioResponse usr=	dms.create(this.setValuesUsr());
			//OK cuando ntreega ID objeto d respuesta
				assertThat(usr.getId().length()>0);
			} catch (Exception e) {
					log.error(e.getMessage());				
					
			}
		
	}
	
/**
 *  prueba de email repetido
 */
	@Test
	void contextLoadsError() {
		
		this.setValuesUsr();
			try {
				dms.create(this.setValuesUsr());
				//en esta llamada se espera la caida
				 dms.create(this. setValuesUsr());
				
			} catch (EmailExisteException e) {
				//se espera un 400, por que el correo ya existe
				assertThat(true);
				log.error("CODIGO DE ERROR-->" + String.valueOf( e.getStatusCode()));
			}
		
	}
	/**
	 * Se crea metodo privado para lleenar un objeto
	 */
private DTOUsuario  setValuesUsr() {
	DTOUsuario dtoUser = new DTOUsuario();
	dtoUser.setEmail	("hucifuen@gmail.com");
	dtoUser.setName		("Hugo Cifuentes");
	dtoUser.setPassword	("123456");
	List<DTOPhone> phones = new ArrayList();
	//se agrega solo un telefono de prueba
	DTOPhone phone = new DTOPhone("123456", "42", "569");
	phones.add(phone);
	
	dtoUser.setPhones(phones);
	
	return dtoUser;
	
}
;}
