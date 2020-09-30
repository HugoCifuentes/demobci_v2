package cl.bci.demo.service;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.demo.dto.DTOPhone;
import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.dto.DTOUsuarioResponse;
import cl.bci.demo.entity.EPhone;
import cl.bci.demo.entity.EUsuario;
import cl.bci.demo.exceptions.EmailExisteException;
import cl.bci.demo.repository.interfaces.IPhoneRepo;
import cl.bci.demo.repository.interfaces.IUsuarioRepo;
import cl.bci.demo.service.interfaces.IDemoService;
import cl.bci.demo.service.mapper.implement.UsuarioMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DemoService implements IDemoService {

@Autowired IUsuarioRepo iUserRepo;
@Autowired IPhoneRepo 	iPhoneR;
@Override
	public DTOUsuarioResponse create(DTOUsuario user) throws EmailExisteException {
	log.info("[metodo:create] Inicio: Demo Service" );

	DTOUsuarioResponse responseCreate = new DTOUsuarioResponse();
//Validar que el correo no este en la base de datos antes de guardar. 
		if(iUserRepo.findByEmail(user.getEmail()).size()>0){
			log.error("Error:["+ user.getEmail()+ "] Correo ya existente en base de datos" );
			throw new EmailExisteException();
			
		}
		EUsuario entidadUsuario = new EUsuario();
		
		UsuarioMapper interfaseUsuarioMapper = new UsuarioMapper();
		entidadUsuario = interfaseUsuarioMapper.dtoUsuario2eUsuario(user);
		
		GregorianCalendar gcalendar = new GregorianCalendar(); 
		entidadUsuario.setCreated	(gcalendar.getTime());	
		entidadUsuario.setLast_login(gcalendar.getTime());
		entidadUsuario.setModified	(gcalendar.getTime());
		entidadUsuario.setIsactive	(true);
//Guarda Usuario
		EUsuario entidadUsuarioResponse = iUserRepo.save(entidadUsuario); 
		log.info("[metodo:save] Usuario creado correctamente,ID="+entidadUsuarioResponse.getId().toString());
		
//Guarda Lista de Telefonos
		for (DTOPhone phone : user.getPhones()) {
			EPhone entidadPhone = new EPhone();
			
			entidadPhone.setContrycode	(phone.getContrycode()			);
			entidadPhone.setIdUsuario	(entidadUsuarioResponse.getId()	);
			entidadPhone.setNumber		(phone.getNumber()				);
			 iPhoneR.save(entidadPhone); 
			
		}
// llena objeto de respuesta
//TODO: Implementar posteriotmente el @Mapping para realizar el trasvasije 
		responseCreate.setCreated(entidadUsuarioResponse.getCreated());
		responseCreate.setId(entidadUsuarioResponse.getId().toString());
		responseCreate.setIsactive(entidadUsuarioResponse.isIsactive());
		responseCreate.setLast_login(entidadUsuarioResponse.getLast_login());
		responseCreate.setModified(entidadUsuarioResponse.getModified());
		log.info("[metodo:save] usuarioo Tocken= "+entidadUsuarioResponse.getToken());

		responseCreate.setToken(entidadUsuarioResponse.getToken().toString());
		responseCreate.setUsuario(user);
		
		return responseCreate;
		
		
	}
	
}
