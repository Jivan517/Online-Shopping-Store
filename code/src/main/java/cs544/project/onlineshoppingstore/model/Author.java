package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Author {
	
	private String id;
	private String firstName;
	private String lastName;
	private Date dob;
	private List<Book> books = new ArrayList<Book>();
	

}
