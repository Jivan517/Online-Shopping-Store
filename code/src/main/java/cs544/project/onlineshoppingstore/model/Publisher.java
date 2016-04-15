package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id @GeneratedValue
	private long id;
	private String publisherid;
	private String name;
	@OneToMany(mappedBy="publisher")
	private List<Book> publishedbooks = new ArrayList<Book>();
	
	

}
