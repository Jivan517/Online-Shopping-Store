package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer extends ACLUser{
	
	private String name;
	
	@OneToOne(mappedBy="customer")
	private ShippingAddress shipingAddress;
	
	@OneToOne(mappedBy="customer")
	private BilingAddress bilingAdrress;
}
