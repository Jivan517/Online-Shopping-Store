package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Address {
	
	@Id @GeneratedValue
	private long id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String zip;
	
	private String street;
	
}
