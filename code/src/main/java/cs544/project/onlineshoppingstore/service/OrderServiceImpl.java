package cs544.project.onlineshoppingstore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cs544.project.onlineshoppingstore.dao.OrderDao;
import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Override
	public void create(Order order) {
		
		orderDao.save(order);
		
	}

	@Override
	public void update(long id, Order updatedOrder) {
		
		orderDao.save(updatedOrder);
		
	}

	@Override
	public void delete(long orderId) {
		orderDao.delete(orderId);
		
	}

	@Override
	public List<Order> findByOrderDate(Date date) {
		return orderDao.findByOrderDate(date);
	}

	@Override
	public List<Order> findByOrderStatus(OrderStatus orderStatus) {
		return orderDao.findByOrderStatus(orderStatus);
	}

}
