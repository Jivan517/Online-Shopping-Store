package cs544.project.onlineshoppingstore.service;

import java.util.Date;
import java.util.List;

import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;

public interface OrderService {

	
	void create(Order order);
	void update(long id, Order updatedOrder);
	void delete(long orderId);
	
	List<Order> findByOrderDate(Date date);
	List<Order> findByOrderStatus(OrderStatus orderStatus);
}
