package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Shipping;
import cs544.project.onlineshoppingstore.model.ShippingType;

public interface ShippingService {

	Shipping get(long shippingId);
	List<Shipping> getAll();
	void create(Shipping shipping);
	void update(long id, Shipping updatedShipping);
	void delete(long shippingId);
	
	List<Shipping> findByShippingType(ShippingType shippingType);
}
