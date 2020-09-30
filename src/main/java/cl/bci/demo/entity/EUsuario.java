package cl.bci.demo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Entity
@Data
public class EUsuario {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column
	private  String  name;
	
	@Column 
	private  String email;
	
	@Column
	private  String password;
	
	@Column
	 private Date created;
	
	@Column
	 private Date modified;
	
	@Column
	 private Date last_login;
	
	@GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	
	@Column(name = "token", updatable = false, nullable = false)
	private UUID token;
	@PrePersist
    public void setLastUpdate() {
        token = UUID.randomUUID();
    }
	
	@Column
	 private boolean isactive;
	
//Constructor	
	
	
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param phones
	 * @param id
	 * @param created
	 * @param modified
	 * @param last_login
	 * @param token
	 * @param isactive
	 */
	public EUsuario(String name, String email, String password,  Date created,
			Date modified, Date last_login, boolean isactive) {
		this.name = name;
		this.email = email;
		this.password = password;
	
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isactive = isactive;
	}
	/**
	 * 
	 */
	public EUsuario() {
	}
	
	
	 
	
	 
	 
}
