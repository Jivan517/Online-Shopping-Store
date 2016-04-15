package cs544.project.onlineshoppingstore.service;

import java.util.List;

import cs544.project.onlineshoppingstore.model.BilingAddress;

public interface BilingAddressService {

	BilingAddress get(long billingAddressId);
	List<BilingAddress> getAll();
	void create(BilingAddress bilingAddress);
	void update(long id, BilingAddress updatedBilingAddress);
	void delete(long BilingAddressId);
	
	List<BilingAddress> findByState(String state);
}
