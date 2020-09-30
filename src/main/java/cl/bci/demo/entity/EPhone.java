package cl.bci.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
public class EPhone {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column
	private String number;
	@Column
	private String citycode;
	@Column
	private String contrycode;
	@Column
	private UUID idUsuario;
	
	
	/**
	 * CONSTRUCTOR
	 * @param number
	 * @param citycode
	 * @param contrycode
	 * @param idUsuario
	 */
	public EPhone(String number, String citycode, String contrycode, UUID idUsuario) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		this.idUsuario = idUsuario;
	}
	public EPhone() {
		// TODO Auto-generated constructor stub
	}

	
}