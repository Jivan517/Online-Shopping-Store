package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Orderline;

public interface OrderlineService {

	Orderline get(long orderlineId);
	List<Orderline> getAll();
	void create(Orderline order);
	void update(long id, Orderline updatedOrder);
	void delete(long orderlineId);
	
	
}
