package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.Email;

@Entity

public class Admin extends ACLUser{
	
	private String name;
	@Email
	private String email;

}
