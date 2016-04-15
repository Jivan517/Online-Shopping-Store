package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity
public class Admin extends ACLUser{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@Email
	private String email;

}
