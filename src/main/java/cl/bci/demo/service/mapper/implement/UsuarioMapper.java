package cl.bci.demo.service.mapper.implement;

import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.entity.EUsuario;
import cl.bci.demo.service.mapper.interfaces.IUsuarioMapper;

public class UsuarioMapper  implements IUsuarioMapper{

	public EUsuario dtoUsuario2eUsuario(DTOUsuario usuario) {
		//TODO: Revisar a posterior la utilización de la anotacion @Mapping
		EUsuario entityUsuario = new EUsuario();
		entityUsuario.setEmail(usuario.getEmail());
		entityUsuario.setName(usuario.getName());
		entityUsuario.setPassword(usuario.getPassword());
		
		return entityUsuario;
	}

}
