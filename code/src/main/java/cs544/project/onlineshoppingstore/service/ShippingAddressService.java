package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.ShippingAddress;

public interface ShippingAddressService {

	ShippingAddress get(long shippingId);
	List<ShippingAddress> getAll();
	void create(ShippingAddress shippingAddress);
	void update(long id, ShippingAddress updatedShippingAddress);
	void delete(long shippingId);
	
	List<ShippingAddress> findByState(String state);
}
