package cs544.project.onlineshoppingstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {

	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	
	private String details;
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "bilingAddressId")
	private BilingAddress bilingAddress;
	
}
