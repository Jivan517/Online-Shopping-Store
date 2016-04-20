package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	
	@JsonIgnore
	@Id @GeneratedValue
	private long id;
	
		
	@NotBlank(message = "First Name filed can not be Empty")
	@Field
	private String firstName;
	
	@Field
	@NotBlank(message = "First Name filed can not be Empty")
	private String lastName;
	
	@Email(message = "Email field not valid")
	private String email;
	
	@Pattern(regexp="[0-9]+",message = "Only numbers allowed.")
	@Size(min=4,max=10)
	private String phone;
	
	@JsonIgnore
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
