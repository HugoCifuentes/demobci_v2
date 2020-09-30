package cl.bci.demo.repository.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.demo.entity.EUsuario;

public interface IUsuarioRepo  extends JpaRepository<EUsuario, UUID> {

	List<EUsuario> findByEmail(String email);
	
	
}
