package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orderline {

	@Id @GeneratedValue
	private long id;
	
	private int quantity;
	
	private double subTotal;
	
}
