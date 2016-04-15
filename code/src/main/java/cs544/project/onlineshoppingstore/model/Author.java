package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Author {
	
	@Id @GeneratedValue
	private long id;
	
		
	@NotBlank(message = "First Name filed can not be null")
	private String firstName;
	
	@NotBlank(message = "First Name filed can not be null")
	private String lastName;
	
	
	@ManyToMany(mappedBy="authors")
	private List<Book> books = new ArrayList<Book>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	

}
