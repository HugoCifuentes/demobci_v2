package cl.bci.demo.service.mapper.interfaces;

import org.mapstruct.factory.Mappers;

import cl.bci.demo.dto.DTOUsuario;
import cl.bci.demo.entity.EUsuario;



public interface IUsuarioMapper {
IUsuarioMapper INSTANCE =  Mappers.getMapper(IUsuarioMapper.class);
	
	//TODO: Revisar a posterior la falla entre lombok, Mapper y STS
	//https://www.thetopsites.net/article/52098625.shtml
	public EUsuario dtoUsuario2eUsuario( DTOUsuario usuario) ;
	
	
}
