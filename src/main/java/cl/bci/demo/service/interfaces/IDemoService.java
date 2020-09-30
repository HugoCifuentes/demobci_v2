package cl.bci.demo.service.interfaces;

import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.dto.DTOUsuarioResponse;
import cl.bci.demo.exceptions.EmailExisteException;

public interface IDemoService {

	DTOUsuarioResponse create(DTOUsuario user) throws EmailExisteException;

}
