package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Review {
	
	@Id @GeneratedValue
	private long id;	
	
	private String review;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Rating can not be null")
	private BookRating rating;	
	
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public BookRating getRating() {
		return rating;
	}

	public void setRating(BookRating rating) {
		this.rating = rating;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
