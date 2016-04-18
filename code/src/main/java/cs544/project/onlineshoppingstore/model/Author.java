package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Author {
	
	@Id @GeneratedValue
	private long id;
	
	@Field
	@NotBlank(message = "First Name filed can not be null")
	private String firstName;
	
	@Field
	@NotBlank(message = "First Name filed can not be null")
	private String lastName;
	
	@NotBlank(message = "Email field can not be empty")
	private String email;
	
	@NotBlank(message = "Phone field can not be empty")
	private String phone;
	
	
	@ManyToMany(mappedBy="authors", cascade=CascadeType.ALL)
	
	private List<Book> books = new ArrayList<Book>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return this.phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getFullName(){
		return this.firstName + " " + this.lastName;
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
	
	@Override
	public String toString(){
		return this.firstName + " " + this.lastName;
	}
	

}
