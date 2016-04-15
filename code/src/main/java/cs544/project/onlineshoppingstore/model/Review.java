package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id @GeneratedValue
	private long id;	
	private String reviewid;
	private String review;
	@Enumerated(EnumType.STRING)
	private BookRating rating;	
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;

}
