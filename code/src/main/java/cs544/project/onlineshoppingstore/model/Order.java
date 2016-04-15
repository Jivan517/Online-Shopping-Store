package cs544.project.onlineshoppingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Order {

	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	private double total;
	private int totalQuantity;
	
	@OneToMany(mappedBy = "order")
	private List<Orderline> orderlines = new ArrayList<>();
	
	
	
}
