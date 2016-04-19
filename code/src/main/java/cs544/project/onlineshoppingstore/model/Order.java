package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BookOrder")
public class Order {

	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Order date cannot be blank.")
	private Date orderDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Delivery date cannot be blank.")
	private Date delivaryDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@NotNull(message = "Total cost cannot be blank.")
	private double total;
	
	@NotNull(message = "Total Quantity cannot be blank.")
	private int totalQuantity;
	
	@OneToMany(mappedBy = "order")
	private List<Orderline> orderlines = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Date getDelivaryDate() {
		return delivaryDate;
	}


	public void setDelivaryDate(Date delivaryDate) {
		this.delivaryDate = delivaryDate;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public List<Orderline> getOrderlines() {
		return orderlines;
	}


	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
