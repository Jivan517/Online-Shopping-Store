package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress extends Address{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
}
