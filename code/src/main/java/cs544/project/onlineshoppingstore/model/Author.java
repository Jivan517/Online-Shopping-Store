package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id @GeneratedValue
	private long id;
	private String authorid;
	private String firstName;
	private String lastName;
	private Date dob;
	
	@ManyToMany(mappedBy="authors")
	private List<Book> books = new ArrayList<Book>();
	

}
