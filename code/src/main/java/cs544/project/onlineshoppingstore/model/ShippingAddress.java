package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress extends Address {

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return this.getStreet() + "\n" + this.getCity() + ", " + this.getState() + ", " + this.getZip() + ", "
				+ this.getCountry();
	}
}
