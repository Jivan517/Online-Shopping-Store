package cs544.project.onlineshoppingstore.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Shipping {

	@Id @GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private ShippingType shippingType;
	
	private double shippingCharge;
	
	@OneToOne()
	@JoinColumn(name ="orderId")
	private Order order;
	
}
