package cs544.project.onlineshoppingstore.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;

public interface OrderDao extends JpaRepository<Order, Long>{

	List<Order> findByOrderDate(Date date);
	List<Order> findByOrderStatus(OrderStatus orderStatus);
	
}
