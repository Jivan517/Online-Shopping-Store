package cs544.project.onlineshoppingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.OrderlineDao;
import cs544.project.onlineshoppingstore.model.Orderline;

@Transactional(propagation = Propagation.REQUIRED)
public class OrderlineServiceImpl implements OrderlineService {

	private OrderlineDao orderlineDao;
	
	@Autowired
	public void setOrderlineDao(OrderlineDao orderlineDao){
		this.orderlineDao = orderlineDao;
	}
	
	@Override
	public Orderline get(long orderlineId) {
		return orderlineDao.findOne(orderlineId);
	}

	@Override
	public List<Orderline> getAll() {
		return orderlineDao.findAll();
	}

	@Override
	public void create(Orderline order) {
		orderlineDao.save(order);
		
	}

	@Override
	public void update(long id, Orderline updatedOrderline) {
		orderlineDao.save(updatedOrderline);
		
	}

	@Override
	public void delete(long orderlineId) {
		orderlineDao.delete(orderlineId);
		
	}

}
