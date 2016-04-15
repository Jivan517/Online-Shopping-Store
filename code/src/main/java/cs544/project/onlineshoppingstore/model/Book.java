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
	private BookType booktype;
	private BookCategory bookcategory;
	
	@ManyToMany
	@JoinTable(name="BOOK_AUTHOR", joinColumns = @JoinColumn(name="isbn"),
	inverseJoinColumns = @JoinColumn(name="authorid"))	
	private List<Author> authorslist = new ArrayList<Author>();
	
	@ManyToOne
	@JoinColumn(name="publisherId")
	private Publisher publisher;
	
	@OneToMany(mappedBy="book")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToOne
	@JoinColumn(name="orderlineId")
	private Orderline orderline;
	

}
