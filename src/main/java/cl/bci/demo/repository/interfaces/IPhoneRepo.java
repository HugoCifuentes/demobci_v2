package cl.bci.demo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bci.demo.entity.EPhone;
import java.util.UUID;

public interface IPhoneRepo extends JpaRepository<EPhone, UUID>{

}
