package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Orderline {

	@Id @GeneratedValue
	private long id;
	
	@NotNull(message = "Quantity cannot be blank.")
	private int quantity;
	
	@NotNull(message = "Sub-total cost cannot be blank.")
	private double subTotal;
	
	@ManyToOne()
	@JoinColumn(name = "orderId")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
