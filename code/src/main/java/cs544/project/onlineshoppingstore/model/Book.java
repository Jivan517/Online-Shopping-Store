package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	
	@Id @GeneratedValue
	private long id;
	private String isbn;
	private String title;
	private String edition;
	private double price;
	private int quantity;
	@Lob
	private Byte[] cover;
	private String description;	
	private BookType bookType;
	private BookCategory bookCategory;
	
	@ManyToMany
	@JoinTable(name="BookAuthor", joinColumns = @JoinColumn(name="bookId"),
	inverseJoinColumns = @JoinColumn(name="authorId"))	
	private List<Author> authors = new ArrayList<Author>();
	
	@ManyToOne
	@JoinColumn(name="publisherId")
	private Publisher publisher;
	
	@OneToMany(mappedBy="book")
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(mappedBy="book")
	private List<Orderline>  orderlines;
	

}
