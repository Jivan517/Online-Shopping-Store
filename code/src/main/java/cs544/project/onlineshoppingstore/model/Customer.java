package cs544.project.onlineshoppingstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends ACLUser{
	
	private String name;
	
	@OneToOne(mappedBy="customer")
	private ShippingAddress shipingAddress;
	
	@OneToOne(mappedBy="customer")
	private BilingAddress bilingAdrress;
	
	@OneToMany(mappedBy="customer")
	private List<Order> order;
}
