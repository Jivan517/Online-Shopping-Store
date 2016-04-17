package cs544.project.onlineshoppingstore.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Book {
	
	
	@Id @GeneratedValue
	private long id;
	
	@NotBlank(message ="ISBN can not be blank")
	private String isbn;
	
	@NotBlank(message ="Title can not be blank")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message ="Release Date can not be blank")
	private Date releaseDate;
	
	@NotNull(message = "Price can not be blank")
	private double price;
	
	@NotNull(message = "Price can not be blank")
	private int quantity;
	
	@Max(value = 2000, message = "Page length can not be greater than 2000")
	@NotNull(message = "Length can not be blank")
	private int length;
	
	@NotBlank(message = "Dimensions can not be blank")
	private String dimension;
	
	private transient MultipartFile cover;
	
	@Lob
	@Column(name = "cover")
	private byte[] bookCover;
	
	@NotBlank(message ="Description can not be blank")
	private String description;	
	
	@NotBlank(message = "Language can not be blank")
	private String language;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull(message = "Book type can not be blank")
	private BookType bookType;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull(message = "Book type can not be blank")
	private BookCategory bookCategory;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="BookAuthor", joinColumns = @JoinColumn(name="bookId"),
	inverseJoinColumns = @JoinColumn(name="authorId"))	
	private List<Author> authors = new ArrayList<Author>();
	
	private transient List<Long> authorIds = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="publisherId")
	private Publisher publisher;
	
	private transient long publisherId;
	
	@OneToMany(mappedBy="book")
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(mappedBy="book")
	private List<Orderline>  orderlines;

	public byte[] getBookCover() {
		return bookCover;
	}

	public void setBookCover(byte[] bookCover) {
		this.bookCover = bookCover;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Long> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(List<Long> authorIds) {
		this.authorIds = authorIds;
	}

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date edition) {
		this.releaseDate = edition;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MultipartFile getCover() {
		return cover;
	}

	public void setCover(MultipartFile cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	
	

}
