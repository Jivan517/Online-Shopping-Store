package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Shipping {

	@Id @GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Shipping type cannot be blank.")
	private ShippingType shippingType;
	
	@NotNull(message = "Shipping charge cannot be blank.")
	private double shippingCharge;
	
	@OneToOne(fetch =FetchType.EAGER)
	@JoinColumn(name ="orderId")
	private Order order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	public double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
