package cs544.project.onlineshoppingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ACLUser {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	private String status;
}
