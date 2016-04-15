package cs544.project.onlineshoppingstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer extends ACLUser{
	
	@NotBlank
	private String name;
	
	@OneToOne(mappedBy="customer")
	private ShippingAddress shipingAddress;
	
	@OneToOne(mappedBy="customer")
	private BilingAddress bilingAdrress;
	
	@OneToMany(mappedBy="customer")
	private List<Order> order;
	
	@Email
	private String email;
}
